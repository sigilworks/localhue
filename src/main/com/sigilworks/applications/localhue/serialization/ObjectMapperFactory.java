package com.sigilworks.applications.localhue.serialization;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sigilworks.applications.localhue.model.Alert;
import com.sigilworks.applications.localhue.model.ColorMode;
import com.sigilworks.applications.localhue.model.Effect;
import com.sigilworks.applications.localhue.model.LightIdentifier;

/**
 * User: tim
 * Date: 9/5/16
 * Time: 11:22 AM
 */
public class ObjectMapperFactory {
    private static final Version version = new Version(1, 0, 0, null, null, null);
    private static ObjectMapper mapper;

    public static ObjectMapper getInstance() {
        if (mapper == null)
            mapper = createMapper();
        return mapper;
    }

    private static ObjectMapper createMapper() {
        return new ObjectMapper()
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(getDeserializers());
    }

    private static Module getDeserializers() {
        return new SimpleModule("LocalHueDeserializers", version)
            .addDeserializer(LightIdentifier.class, new LightIdentifierDeserializer())
            .addDeserializer(ColorMode.class, new ColorModeDeserializer())
            .addDeserializer(Effect.class, new EffectDeserializer())
            .addDeserializer(Alert.class, new AlertDeserializer());
    }
}

