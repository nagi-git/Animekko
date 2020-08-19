package com.example.demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.WorksDto;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TitleService {

	@Autowired
	@Qualifier("titleSearchRestTemplate")
	RestTemplate restTemplate;

	/** アニメ検索API リクエストURL */

	public WorksDto service(String title) {
		System.out.println("service呼び出し成功");

		String URL = "https://api.annict.com/v1/works?filter_title=" + title
				+ "&access_token=6TCOx_Yr4oe0vnENIq01CruyxtHMzh-is19txE8t5kM";
		getJsonNode(searchService(URL));
		return restTemplate.getForObject(URL, WorksDto.class, title);
	}

	public String searchService(String urlStr) {
		String result = "";

		try {
			URL url = new URL(urlStr);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String tmp = "";
			while ((tmp = in.readLine()) != null) {
				result += tmp;
			}
			in.close();
			con.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static JsonNode getJsonNode(String jsonString) {
		JsonNode node = null;
		try {
			JsonFactory jfactory = new JsonFactory();
			JsonParser parser = jfactory.createJsonParser(jsonString);
			ObjectMapper mapper = new ObjectMapper();
			node = mapper.readTree(parser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return node;
	}

}
