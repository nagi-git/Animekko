package com.example.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.WorksDataDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TitleService {

	public static String getResult(String title) {
		String result = "";
		try {
			String urlStr = "https://api.annict.com/v1/works?filter_title=" + title
					+ "&access_token=6TCOx_Yr4oe0vnENIq01CruyxtHMzh-is19txE8t5kM";
			java.net.URL url = new java.net.URL(urlStr);
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

	public WorksDataDto service(String title) {
		System.out.println("service呼び出し成功");
		List<WorksDataDto> worksDataDto;

		String result = getResult(title);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(result);

			int id = node.get("id").asInt();
			System.out.println(id);

			String title_kana = node.get("title_kana").asText();
			System.out.println(title_kana);

			String images = node.get("images").get(0).get("recommended_url").asText();
			System.out.println(images);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mapper;
	}
}
