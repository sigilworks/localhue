package com.sigilworks.applications.localhue.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sigilworks.applications.localhue.model.LightIdentifier;

import java.io.IOException;

/**
 * User: tim
 * Date: 9/5/16
 * Time: 11:21 AM
 */
public class LightIdentifierDeserializer extends JsonDeserializer<LightIdentifier> {

    @Override
    public LightIdentifier deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return new LightIdentifier(jp.getValueAsString());
    }
}
