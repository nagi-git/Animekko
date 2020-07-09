package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class WorksDto {

	private int total_count;

	private int next_page;

	private int prev_page;

	/** 作品情報リスト */
	private List<WorksDataDto> works;

}
