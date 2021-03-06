package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WorksDataDto {

	/** ID */
	@JsonProperty("id")
	int id;

	/** タイトル */
	@JsonProperty("title")
	String title;

	/** タイトルかな */
	@JsonProperty("title_kana")
	String title_kana;

	/** リリース媒体 */
	@JsonProperty("media")
	String media;

	/** リリース媒体テキスト */
	@JsonProperty("media_text")
	String media_text;

	/** リリース時期 */
	@JsonProperty("season_name")
	String season_name;

	/** リリース時期 (表記用) */
	@JsonProperty("season_name_text")
	String season_name_text;

	/** リリース日 */
	@JsonProperty("released_on")
	String released_on;

	/** 未確定な大体のリリース日 */
	@JsonProperty("released_on_about")
	String released_on_about;

	/** サイトURL */
	@JsonProperty("official_site_url")
	String official_site_url;

	/** ウィキペディアURL */
	@JsonProperty("wikipedia_url")
	String wikipedia_url;

	/** ツイッターユーザー名 */
	@JsonProperty("twitter_username")
	String twitter_username;

	/** ツイッターハッシュタグ */
	@JsonProperty("twitter_hashtag")
	String twitter_hashtag;

	/** しょぼいカレンダーのタイトルID */
	@JsonProperty("syobocal_tid")
	String syobocal_tid;

	/** MyAnimeListの作品ID */
	@JsonProperty("mal_anime_id")
	String mal_anime_id;

	/** エピソード数 */
	@JsonProperty("episodes_count")
	int episodes_count;

	/** 見てる / 見たい / 見た人の数 */
	@JsonProperty("watchers_count")
	int watchers_count;

	/** レビュー数 */
	@JsonProperty("reviews_count")
	int reviews_count;

	/** エピソードが存在しない作品かどうか */
	@JsonProperty("no_episodes")
	boolean no_episodes;

	@JsonProperty("images")
	WorksDataDto.Images images;

	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	public class Images {

		@JsonProperty("recommended_url")
		private String recommended_url;
	}
}
