package by.jum.internetbanking.util;

public enum ValidationConstants {
    NAME_PATTERN("[a-zA-Z]+"),
    PASSPORT_NUMBER_LOGIN_PASS_PATTERN("[a-zA-Z0-9_]+"),
    NUMBER_PATTERN("[0-9]+"),
    PHONE_NUMBER("[+]{1}[0-9]+");

    private String pattern;

    ValidationConstants(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
