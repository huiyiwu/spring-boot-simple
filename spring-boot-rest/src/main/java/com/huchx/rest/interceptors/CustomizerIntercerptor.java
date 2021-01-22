package com.huchx.rest.interceptors;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.PortableInterceptor.ClientRequestInterceptor;
import org.omg.PortableInterceptor.ClientRequestInterceptorOperations;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Author: Huchx
 * Date: 2021/1/22 16:30
 */
public class CustomizerIntercerptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        logRequest(httpRequest);

        return clientHttpRequestExecution.execute(httpRequest,body);
    }

    private void logRequest(HttpRequest httpRequest) {
        System.out.println("RestTemplate Request Interceptor");
    }
}
