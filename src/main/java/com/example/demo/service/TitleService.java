package com.example.demo.service;

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

	public WorksDto service(String title) {
		// ログ出力
		System.out.println("service呼び出し成功");

		String URL = "https://api.annict.com/v1/works?filter_title=" + title
				+ "&access_token=6TCOx_Yr4oe0vnENIq01CruyxtHMzh-is19txE8t5kM";

		return restTemplate.getForObject(URL, WorksDto.class, title);
	}

}
