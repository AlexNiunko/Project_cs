package com.car_sharing.project_cs.encryption;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryption {
    public static String encrypt(String password){
        MessageDigest messageDigest;
        byte [] byteEncoded;
        try {
            messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes("utf8"));
            byteEncoded= messageDigest.digest();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        BigInteger bigInt=new BigInteger(1,byteEncoded);
        String resHex= bigInt.toString(16);
        return resHex;
    }

}
