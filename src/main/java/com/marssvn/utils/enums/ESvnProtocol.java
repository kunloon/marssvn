package com.marssvn.utils.enums;

/**
 * svn protocol
 */
public enum ESvnProtocol {
    /**
     * file:///
     */
    FILE("file"),

    /**
     * svn://
     */
    SVN("svn"),

    /**
     * http://
     */
    HTTP("http"),

    /**
     * https://
     */
    HTTPS("https");

    private String value;

    ESvnProtocol(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getPrefix() {
        return this.value + "://";
    }
}
