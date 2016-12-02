package com.sigilworks.applications.localhue.model;

/**
 * User: tim
 * Date: 9/4/16
 * Time: 5:43 PM
 */
public class LightIdentifier {
    private final String id;

    public LightIdentifier(String id) {
        this.id = id;
    }

    public String id() { return id; }

    @Override public String toString() { return id; }
}
