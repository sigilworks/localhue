package com.sigilworks.applications.localhue.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

/**
 * User: tim
 * Date: 9/4/16
 * Time: 5:45 PM
 */
@JsonAutoDetect(fieldVisibility=ANY)
public class LightState {
    @JsonProperty("on") private boolean on;
    @JsonProperty("bri") private int brightness;
    @JsonProperty("hue") private int hue;
    @JsonProperty("sat") private int saturation;
    // CIE color space XY coords
    @JsonProperty("xy") private double[] colorCoordinates;
    // Mired color temp. (153: 6500K, 500: 2000K)
    @JsonProperty("ct") private int temperature;
    @JsonProperty("alert") private Alert alert;
    @JsonProperty("effect") private Effect effect;
    @JsonProperty("colormode") private ColorMode colorMode;
    @JsonProperty("reachable") private boolean reachable;


    public Alert getAlert() { return alert; }
    public LightState setAlert(Alert alert) { this.alert = alert; return this; }
    public int getBrightness() { return brightness; }
    public LightState setBrightness(int brightness) { this.brightness = brightness; return this; }
    public double[] getColorCoordinates() { return colorCoordinates; }
    public LightState setColorCoordinates(double[] colorCoordinates) { this.colorCoordinates = colorCoordinates; return this; }
    public ColorMode getColorMode() { return colorMode; }
    public LightState setColorMode(ColorMode colorMode) { this.colorMode = colorMode; return this; }
    public Effect getEffect() { return effect; }
    public LightState setEffect(Effect effect) { this.effect = effect; return this; }
    public int getHue() { return hue; }
    public LightState setHue(int hue) { this.hue = hue; return this; }
    public boolean isOn() { return on; }
    public LightState setOn(boolean on) { this.on = on; return this; }
    public boolean isReachable() { return reachable; }
    public LightState setReachable(boolean reachable) { this.reachable = reachable; return this; }
    public int getSaturation() { return saturation; }
    public LightState setSaturation(int saturation) { this.saturation = saturation; return this; }
    public int getTemperature() { return temperature; }
    public LightState setTemperature(int temperature) { this.temperature = temperature; return this; }
}
