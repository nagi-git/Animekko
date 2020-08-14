package com.example.demo.service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.WorksDto;

@Service
public class TitleService {

	@Autowired
	@Qualifier("titleSearchRestTemplate")
	RestTemplate restTemplate;

	/** アニメ検索API リクエストURL */
	private static final String URL = "https://api.annict.com/v1/works?filter_title={title}&access_token=6TCOx_Yr4oe0vnENIq01CruyxtHMzh-is19txE8t5kM";

	public WorksDto service(String title) {
		System.out.println("service呼び出し成功");
		return restTemplate.getForObject(URL, WorksDto.class, title);
	}

	public String postJson(String json, String title) {
		HttpURLConnection uc;
		try {
			URL url = new URL("https://api.annict.com/v1/works?filter_title=" + title
					+ "&access_token=6TCOx_Yr4oe0vnENIq01CruyxtHMzh-is19txE8t5kM");
			uc = (HttpURLConnection) url.openConnection();
			uc.setRequestMethod("POST");
			uc.setUseCaches(false);
			uc.setDoOutput(true);
			uc.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			OutputStreamWriter out = new OutputStreamWriter(new BufferedOutputStream(uc.getOutputStream()));
			out.write(json);
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String line = in.readLine();
			String body = "";
			while (line != null) {
				body = body + line;
				line = in.readLine();
			}
			uc.disconnect();
			return body;
		} catch (IOException e) {
			e.printStackTrace();
			return "client - IOException : " + e.getMessage();
		}
	}
}
