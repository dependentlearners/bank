package com.dependentlearners.common.filter;

import com.dependentlearners.common.model.LoggerConstants;
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
import java.io.IOException;
import java.util.UUID;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE+1)
@Slf4j
public class GlobalApiContextEnricherFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Initializing Api Context Enricher filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        setThreadContextValues((HttpServletRequest) request);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("Gracefully destroying Api Context Enricher filter");
    }

    private static void setThreadContextValues(HttpServletRequest httpRequest) {
        if (httpRequest.getHeader(LoggerConstants.CORRELATION_ID_HEADER_NAME) != null) {
            MDC.put("ContextID", httpRequest.getHeader(LoggerConstants.CORRELATION_ID_HEADER_NAME));
        }
        else {
            MDC.put("ContextID", UUID.randomUUID().toString());
        }
    }
}