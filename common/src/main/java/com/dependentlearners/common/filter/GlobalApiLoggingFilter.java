package com.dependentlearners.common.filter;

import com.dependentlearners.common.model.RequestWrapper;
import com.dependentlearners.common.model.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class GlobalApiLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Initializing Api request response logging filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        logRequestHeaderValues(httpRequest);
        try {
            httpRequest = new RequestWrapper((HttpServletRequest) request);
            httpResponse = new ResponseWrapper((HttpServletResponse) response);
            filterChain.doFilter(httpRequest, httpResponse);
        } finally {
            long elapsedTime = System.currentTimeMillis() - startTime;
            log.info("RequestURL={} , ServiceProcessingTime={} ", httpRequest.getRequestURI(),
                    elapsedTime);
            log.debug("RequestPayload={} , ResponsePayload={}", requestPayload((RequestWrapper)httpRequest), responsePayload((ResponseWrapper)httpResponse));
            logResponseHeaderValues(httpResponse);
            MDC.clear();
        }
    }

    @Override
    public void destroy() {
        log.info("Gracefully destroying request response logging filter");
    }

    private void logRequestHeaderValues(HttpServletRequest httpRequest) {

        Map<String, String> map = new HashMap<String, String>();

        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = httpRequest.getHeader(key);
            map.put(key, value);
        }

        log.debug("RequestHeaders={}",map);

    }

    private void logResponseHeaderValues(HttpServletResponse httpResponse) {

        Map<String, String> map = new HashMap<String, String>();

        Collection<String> headerNames = httpResponse.getHeaderNames();
        headerNames.forEach(key -> {
            map.put(key, httpResponse.getHeader(key));
        });
        log.debug("ResponseHeaders={}", map);

    }

    private static String requestPayload(final RequestWrapper request) {
        StringBuilder msg = new StringBuilder();

        if (!isMultipart(request) && !isBinaryContent(request)) {
            try {
                String charEncoding = request.getCharacterEncoding() != null ? request.getCharacterEncoding() :
                        "UTF-8";
                msg.append(new String(request.toByteArray(), charEncoding));
                return msg.toString();
            } catch (UnsupportedEncodingException e) {
                log.warn("Failed to parse request payload", e);

            }

        } else {
            log.debug("Content Type is either multipart or binary and hence request payload will not be logged");
        }
        return null;

    }

    private static String responsePayload(final ResponseWrapper response) {

        if (isApplicationJson(response)) {
            StringBuilder msg = new StringBuilder();
            try {
                msg.append(new String(response.toByteArray(), response.getCharacterEncoding()));
                return msg.toString();
            } catch (UnsupportedEncodingException e) {
                log.warn("Failed to parse response payload", e);
            }
        } else {
            log.debug("Content Type is json and hence response payload will not be logged");

        }
        return null;

    }

    /**
     * Check whether the request content is binary (video,image,audio).
     * @param request The servlet request object
     * @return true if its a binary content
     */
    private static boolean isBinaryContent(final HttpServletRequest request) {
        if (request.getContentType() == null) {
            return false;
        }
        return request.getContentType().startsWith("image") || request.getContentType().startsWith("video") || request.getContentType().startsWith("audio");
    }

    /**
     * Check whether the request content is of type multipart
     * @param request the servlet request
     * @return true if content type is multipart
     */
    private static boolean isMultipart(final HttpServletRequest request) {
        return request.getContentType() != null && request.getContentType().startsWith("multipart/form-data");
    }

    /**
     * Check whether the request content is binary (video,image,audio).
     * @param response The servlet request object
     * @return true if its a binary content
     */
    private static boolean isApplicationJson(final HttpServletResponse response) {
        if (response.getContentType() == null) {
            return false;
        }
        return response.getContentType().contains("json");
    }

}
