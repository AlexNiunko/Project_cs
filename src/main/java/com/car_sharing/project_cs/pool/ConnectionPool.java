package com.car_sharing.project_cs.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    static final Logger logger = LogManager.getLogger();
    private static final int POOL_SIZE = 8;
    private static ConnectionPool connectionInstance;
    private static Lock locker = new ReentrantLock();
    private static AtomicBoolean isInitialized = new AtomicBoolean(false);
    private BlockingQueue<ProxyConnection> free = new LinkedBlockingQueue<>();
    private BlockingQueue<ProxyConnection> busy =new LinkedBlockingQueue<>();

    static {
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            logger.warn("Failed to register  MySql Driver {}",e.getMessage());
        }
    }

    private ConnectionPool() {
        String url="jdbc:mysql://localhost:3306/car_sharing";
        Properties prop=new Properties();
        prop.put("user","root");
        prop.put("password","AlexDasha8921_qwe");

        for (int i = 0; i < POOL_SIZE; i++) {
            Connection connection=null;
            try {
                free.add(new ProxyConnection(DriverManager.getConnection(url,prop)));
            } catch (SQLException e) {
                logger.warn("Failed to create connection {}", e.getMessage());
            }
        }
    }

    public static ConnectionPool getInstance() {
        if (!isInitialized.get()) {
            try {
                locker.lock();
                if (connectionInstance == null) {
                    connectionInstance = new ConnectionPool();
                    isInitialized.set(true);
                }
            } finally {
                locker.unlock();
            }
        }
        return connectionInstance;
    }

    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = free.take();
            busy.put( connection);
        } catch (InterruptedException e) {
            logger.warn("failed to take connection from pool {}", e.getMessage());
        }
        return connection;
    }

    public void returnConnection(Connection connection) {
        try {
            if (connection instanceof ProxyConnection) {
                ProxyConnection proxy = (ProxyConnection) connection;
                busy.remove(proxy);
                free.put(proxy);
            } else {
                logger.warn("Enemy connection");
            }
        } catch (InterruptedException e) {
            logger.warn("failed to return connection to pool {}", e.getMessage());
        }
    }

    private void deregisterDriver() {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.warn("Failed to deregister driver {}", e.getMessage());
            }
        });
    }

    public void destroyPool() {
        for (int i = 0; i < this.free.size(); i++) {
            try {
                free.take().reallyClose();
            } catch (InterruptedException e) {
                logger.warn("Failed to close connection {}", e.getMessage());
            }
        }
        deregisterDriver();
    }



}
