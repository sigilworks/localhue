package com.sigilworks.applications.localhue.model;

/**
 * User: tim
 * Date: 9/5/16
 * Time: 11:35 AM
 */
public enum Alert {
    None("none"),
    BreatheCycle("select"),
    RepeatedBreatheCycles("lselect");

    private String code;

    Alert(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static Alert fromCode(String code) {
        for (Alert alert : values())
            if (alert.getCode().equalsIgnoreCase(code))
                return alert;
        return null;
    }
}
