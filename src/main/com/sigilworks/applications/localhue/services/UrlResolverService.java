package com.sigilworks.applications.localhue.services;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * User: tim
 * Date: 9/4/16
 * Time: 5:32 PM
 */
public class UrlResolverService {
    public static final String EMPTY_CONTEXT_URL_FORMAT = "%s://%s:%s/";
    public static final String BASE_URL_FORMAT = "%s://%s:%s/%s/";

    private final String host;
    private final int port;
    private final boolean useSSL;
    private final String contextPath;
    private final String baseUrl;

    public UrlResolverService(String url) {
        URI uri = URI.create(url);
        this.host = uri.getHost();
        this.port = uri.getPort();
        this.useSSL = uri.getScheme().equals("https");
        this.contextPath = uri.getPath();
        this.baseUrl = createBaseUrl();
    }

    private String createBaseUrl() {
        String scheme = useSSL ? "https" : "http";
        String hostname = host;
        String path = contextPath.endsWith("/") ? contextPath.substring(0, contextPath.length() - 1) : contextPath;
        path = path.startsWith("/") ? path.substring(1) : path;
        return path.isEmpty()
                ? String.format(EMPTY_CONTEXT_URL_FORMAT, scheme, hostname, port)
                : String.format(BASE_URL_FORMAT, scheme, hostname, port, path);

    }

    public String resolve(String fragment) {
        String path = fragment.startsWith("/") ? fragment.substring(1) : fragment;
        return baseUrl + path;
    }

    public URL resolveUrl(String fragment) {
        String path = fragment.startsWith("/") ? fragment.substring(1) : fragment;
        try {
            return new URL(baseUrl + path);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unable to create URL from for `" + baseUrl + path + "`.", e);
        }
    }
}
