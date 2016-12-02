package com.sigilworks.applications.localhue.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;

/**
 * User: tim
 * Date: 9/4/16
 * Time: 5:29 PM
 */
public class SceneService extends AbstractService {

    public SceneService(UrlResolverService urlResolver, ObjectMapper mapper, Client jaxClient) {
        super(urlResolver, mapper, jaxClient);
    }
}
