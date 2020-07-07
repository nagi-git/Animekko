package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class TitleDto {
	private int total_count;

	private int next_page;

	private int prev_page;

	/** リスト */
	private List<TitleDataDto> works;

}
