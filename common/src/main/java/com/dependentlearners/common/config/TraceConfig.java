package com.dependentlearners.common.config;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.metric.SpanMetricReporter;
import org.springframework.cloud.sleuth.zipkin.HttpZipkinSpanReporter;
import org.springframework.cloud.sleuth.zipkin.ZipkinProperties;
import org.springframework.cloud.sleuth.zipkin.ZipkinSpanReporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import zipkin.Span;

@Configuration
public class TraceConfig {

    private final EurekaClient eurekaClient;

    private final SpanMetricReporter spanMetricReporter;

    private final ZipkinProperties zipkinProperties;

    @Value("${spring.sleuth.web.skipPattern}")
    private String skipPattern;

    @Autowired
    public TraceConfig(EurekaClient eurekaClient, SpanMetricReporter spanMetricReporter, ZipkinProperties zipkinProperties) {
        this.eurekaClient = eurekaClient;
        this.spanMetricReporter = spanMetricReporter;
        this.zipkinProperties = zipkinProperties;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ZipkinSpanReporter makeZipkinSpanReporter() {
        return new ZipkinSpanReporter() {
            private HttpZipkinSpanReporter delegate;
            private String baseUrl;

            @Override
            public void report(Span span) {
                InstanceInfo instance = eurekaClient.getNextServerFromEureka("service-trace", false);
                if (baseUrl == null || !instance.getHomePageUrl().equals(baseUrl)) {
                    baseUrl = instance.getHomePageUrl();
                }
                delegate = new HttpZipkinSpanReporter(restTemplate(), baseUrl,
                        zipkinProperties.getFlushInterval(),
                        spanMetricReporter);
                if (!span.name.matches(skipPattern)) {
                    delegate.report(span);
                }
            }
        };
    }

}
