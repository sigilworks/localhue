package com.sigilworks.applications.localhue.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sigilworks.applications.localhue.model.LightIdentifier;
import com.sigilworks.applications.localhue.model.LightResource;

import java.util.Map;

/**
 * User: tim
 * Date: 9/4/16
 * Time: 5:29 PM
 */
public class LightService extends AbstractService {

    public LightService(UrlResolverService urlResolver, ObjectMapper mapper, Client jaxClient) {
        super(urlResolver, mapper, jaxClient);
    }

    public Map<LightIdentifier, LightResource> getAllLights() {
        WebResource resource = getResourceForUrlPath("lights");
        return resource.get(new GenericType<Map<LightIdentifier, LightResource>>(){});
    }
}
