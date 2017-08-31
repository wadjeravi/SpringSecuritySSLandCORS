package com.shutterfly.cns.config;


import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter{

    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cns/notification")
                .allowedOrigins("https://marcomcentral.app.pti.com","https://localhost:8446")
                .allowedMethods(HttpMethod.POST.toString(),HttpMethod.OPTIONS.toString())
                .allowedHeaders("*")
                .allowCredentials(true).maxAge(3600);
    }

}
