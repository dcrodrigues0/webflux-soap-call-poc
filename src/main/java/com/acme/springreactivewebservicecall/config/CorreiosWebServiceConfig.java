package com.acme.springreactivewebservicecall.config;

import com.acme.springreactivewebservicecall.gateway.CorreiosGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CorreiosWebServiceConfig {

    @Value("${webservices.correios.info.defaultUri}")
    private String defaultUri;

    @Value("${webservices.correios.info.contextPath}")
    private String contextPath;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(contextPath);
        return marshaller;
    }

    @Bean
    public CorreiosGateway correiosGateway(Jaxb2Marshaller marshaller) {
        CorreiosGateway client = new CorreiosGateway();
        client.setDefaultUri(defaultUri);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
