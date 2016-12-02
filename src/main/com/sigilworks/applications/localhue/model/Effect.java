package com.sigilworks.applications.localhue.model;

/**
 * User: tim
 * Date: 9/5/16
 * Time: 11:35 AM
 */
public enum Effect {
    None("none"),
    ColorLoop("colorloop");

    private String code;

    Effect(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static Effect fromCode(String code) {
        for (Effect effect : values())
            if (effect.getCode().equalsIgnoreCase(code))
                return effect;
        return null;
    }
}
