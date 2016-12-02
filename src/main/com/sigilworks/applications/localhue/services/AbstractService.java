package com.sigilworks.applications.localhue.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * User: tim
 * Date: 9/4/16
 * Time: 5:37 PM
 */
public abstract class AbstractService {
    protected final UrlResolverService urlResolver;
    protected final ObjectMapper mapper;
    protected final Client jaxClient;

    public AbstractService(UrlResolverService urlResolver, ObjectMapper mapper, Client jaxClient) {
        this.urlResolver = urlResolver;
        this.mapper = mapper;
        this.jaxClient = jaxClient;
    }

    protected WebResource getResourceForUrlPath(String path) {
        return jaxClient.resource(urlResolver.resolve(path));
    }

    protected <T> String asSerialized(T obj) {
        String serializedRequest = null;
        try {
            serializedRequest = mapper.writeValueAsString(obj);
            return serializedRequest;
            // System.out.println("serialized request: " + serializedRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JIRA rest client unable to serialize object of type " + obj.getClass().getName());
        }
    }
}
