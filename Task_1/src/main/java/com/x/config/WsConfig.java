package com.x.config;


import com.x.service.TaxService;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WsConfig {
    @Autowired
    private TaxService taxService; ;

    @Autowired
    private Bus busService;

    @Bean
    public ServletRegistrationBean hisService() {
        return new ServletRegistrationBean<>(new CXFServlet(),"/ws/*");
    }

    @Bean
    public Endpoint hisServiceEndpoint() {
        EndpointImpl ep = new EndpointImpl(busService, taxService);
        ep.publish("/tax");
        return ep;
    }
}
