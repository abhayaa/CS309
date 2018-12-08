package com.cs309.busQr.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
@Configuration
@EnableWebMvc
@ComponentScan("com.cs309.services")
public class OnlineConfig implements WebMvcConfigurer {

//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> convList) {
//		MappingJackson2HttpMessageConverter conv = new MappingJackson2HttpMessageConverter();
//		conv.setObjectMapper(new ObjectMapper());
//		conv.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//		convList.add(conv);
//	}

}
