package com.onlinestore.kodigonlinestore.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
        private static final String CREATE ="CREATE";
        private static final String UPDATE ="UPDATE";
        private static final String PUT ="PUT";
        private static final String DELETE ="DELETE";

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedMethods(CREATE,UPDATE,PUT,DELETE)
                    .allowedHeaders("*")
                    .allowedOriginPatterns("*")
                    .allowCredentials(true);
        }


}
