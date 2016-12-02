package com.sigilworks.applications.localhue.model;

/**
 * User: tim
 * Date: 9/5/16
 * Time: 11:36 AM
 */
public enum ColorMode {
    HueSaturation("hs"),
    XY("xy"),
    ColorTemperature("ct");

    private String code;

    ColorMode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static ColorMode fromCode(String code) {
        for (ColorMode mode : values())
            if (mode.getCode().equalsIgnoreCase(code))
                return mode;
        return null;
    }
}
