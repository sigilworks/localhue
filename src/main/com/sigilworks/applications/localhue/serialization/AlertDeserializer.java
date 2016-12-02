package com.sigilworks.applications.localhue.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sigilworks.applications.localhue.model.Alert;

import java.io.IOException;

/**
 * User: tim
 * Date: 9/5/16
 * Time: 12:30 PM
 */
public class AlertDeserializer extends JsonDeserializer<Alert> {
    @Override
    public Alert deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return Alert.fromCode(jp.getValueAsString());
    }
}