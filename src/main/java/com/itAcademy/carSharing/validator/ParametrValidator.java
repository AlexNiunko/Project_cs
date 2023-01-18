package com.itAcademy.carSharing.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParametrValidator {

    private ParametrValidator() {

    }

    public static boolean validateDrivingLicenseNumber(String input) {
        boolean res;
        Pattern pattern = Pattern.compile(ParametrPattern.DRIVING_LICENSE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        res = matcher.matches();
        return res;
    }

    public static boolean validateDateOfExpirity(String input) {
        boolean res;
        Pattern pattern = Pattern.compile(ParametrPattern.DATE_OF_EXPIRITY_PATTERN);
        Matcher matcher = pattern.matcher(input);
        res = matcher.matches();
        return res;
    }

    public static boolean validateNameOrSurname(String input) {
        boolean res;
        Pattern pattern = Pattern.compile(ParametrPattern.NAME_PATTERN);
        Matcher matcher = pattern.matcher(input);
        res = matcher.matches();
        return res;
    }

    public static boolean validatePassword(String input) {
        boolean res;
        Pattern pattern = Pattern.compile(ParametrPattern.PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(input);
        res = matcher.matches();
        return res;
    }

    public static boolean validateEmail(String input) {
        boolean res;
        Pattern pattern = Pattern.compile(ParametrPattern.EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(input);
        res = matcher.matches();
        return res;
    }
}
