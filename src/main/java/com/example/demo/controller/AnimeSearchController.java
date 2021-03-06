package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.WorksDto;
import com.example.demo.service.TitleService;

@Controller
public class AnimeSearchController {

	@Autowired
	TitleService titleService;

	/**
	 * GET用の処理.
	 */
	@RequestMapping("/home")
	public String homeForm(HttpSession session, Model model) {
		// コンテンツ部分にホーム画面を表示するための文字列を登録
		model.addAttribute("contents", "search/home :: home_contents");

		// title.htmlに画面遷移
		return "search/homeLayout";
	}

	/**
	 * アニメ情報一覧表示
	 * 
	 * @return "home-confirm"
	 */
	@RequestMapping(value = "/home/confirm", method = RequestMethod.POST)
	public String homeConfirm(HttpSession session, Model model, @RequestParam("title") String title) {

		System.out.println("homeConfirm呼び出し成功");

		// 一応必須チェックのみ 数字・桁数チェックは省略
		// nullまたは空文字の場合、入力フォームにエラーメッセージを表示
		if (title == null || title.equals("")) {
			model.addAttribute("errorMessage", "作品名を入力してください。");
			return homeForm(session, model);
		}

		// アニメ検索APIサービス呼び出し
		WorksDto worksDto = titleService.service(title);

		System.out.println("titleService.service呼び出し成功");

		// thymeleafでリストを展開して表示する
		model.addAttribute("worksList", worksDto.getWorks());
		System.out.println("model.addAttribute呼び出し成功");

		// コンテンツ部分に検索結果一覧を表示するための文字列を登録
		model.addAttribute("contents", "search/searchConfirm :: searchConfirm_contents");

		return "search/homeLayout";
	}
}
