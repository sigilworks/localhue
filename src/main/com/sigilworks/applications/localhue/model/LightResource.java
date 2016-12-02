package com.sigilworks.applications.localhue.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

/**
 * User: tim
 * Date: 9/4/16
 * Time: 5:44 PM
 */
@JsonAutoDetect(fieldVisibility= ANY)
public class LightResource {
    @JsonProperty("state") private LightState state;
    @JsonProperty("type") private String type;
    @JsonProperty("name") private String name;
    @JsonProperty("modelid") private String modelId;
    @JsonProperty("manufacturername") private String manufacturer;
    @JsonProperty("uniqueid") private String uid;
    @JsonProperty("swversion") private String softwareVersion;

    public LightState getState() { return state; }
    public LightResource setState(LightState state) { this.state = state; return this; }
    public String getManufacturer() { return manufacturer; }
    public String getModelId() { return modelId; }
    public String getName() { return name; }
    public String getSoftwareVersion() { return softwareVersion; }
    public String getType() { return type; }
    public String getUid() { return uid; }
}
