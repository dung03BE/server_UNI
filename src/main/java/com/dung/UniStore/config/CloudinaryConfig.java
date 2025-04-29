package com.dung.UniStore.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "djwnximto");
        config.put("api_key", "722312826933491");
        config.put("api_secret", "5Lev7TzzADcClossOv_KDvZMr1Q");
        config.put("secure", "true");

        return new Cloudinary(config);
    }
}
