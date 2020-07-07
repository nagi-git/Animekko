package com.example.demo.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateResolver {
	@Bean
	public RestTemplate titleSearchRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

		List<MediaType> supportedMediaTypes = new ArrayList<>(messageConverter.getSupportedMediaTypes());

		// application/jsonのJacksonの処理対象にくわえる
		supportedMediaTypes.add(MediaType.APPLICATION_JSON);
		messageConverter.setSupportedMediaTypes(supportedMediaTypes);

		// カスタムしたHttpMessageConverterを適用
		restTemplate.setMessageConverters(Collections.singletonList(messageConverter));

		return restTemplate;
	}
}
