package com.sigilworks.applications.localhue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sigilworks.applications.localhue.model.LightIdentifier;
import com.sigilworks.applications.localhue.model.LightResource;
import com.sigilworks.applications.localhue.serialization.ObjectMapperFactory;
import com.sigilworks.applications.localhue.services.LightService;
import com.sigilworks.applications.localhue.services.SceneService;
import com.sigilworks.applications.localhue.services.UrlResolverService;

import java.util.Map;

/**
 * User: tim
 * Date: 9/4/16
 * Time: 1:52 PM
 */
public class HueClient {
    private final LightService lightsService;
    private final SceneService sceneService;

    public HueClient() {
        final UrlResolverService urlResolver = new UrlResolverService(LocalHueConstants.BASE_URL);
        // set up our Jackson (de-)serialization
        final ObjectMapper mapper = ObjectMapperFactory.getInstance();
        // instantiate a Jersey REST client
        final Client jaxClient = createClient(mapper);
        // create the various services to access the API
        this.lightsService = new LightService(urlResolver, mapper, jaxClient);
        this.sceneService = new SceneService(urlResolver, mapper, jaxClient);
    }

    private Client createClient(ObjectMapper mapper) {
        final ClientConfig clientConf = new DefaultClientConfig();
        clientConf.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
        clientConf.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
        clientConf.getSingletons().add(new JacksonJsonProvider(mapper));
        return Client.create(clientConf);
    }

    public LightService getLightsService() { return lightsService; }

    public SceneService getSceneService() { return sceneService; }

    public static void main(String[] args) {
        final HueClient hueClient = new HueClient();
        final Map<LightIdentifier, LightResource> allLights = hueClient.getLightsService().getAllLights();

        System.out.println("all lights: " + allLights);
    }
}
