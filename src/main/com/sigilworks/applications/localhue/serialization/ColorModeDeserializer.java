package com.sigilworks.applications.localhue.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sigilworks.applications.localhue.model.ColorMode;

import java.io.IOException;

/**
 * User: tim
 * Date: 9/5/16
 * Time: 11:48 AM
 */
public class ColorModeDeserializer extends JsonDeserializer<ColorMode> {
    @Override
    public ColorMode deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return ColorMode.fromCode(jp.getValueAsString());
    }
}
