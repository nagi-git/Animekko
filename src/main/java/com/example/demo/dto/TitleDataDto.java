package com.example.demo.dto;

import lombok.Data;

@Data
public class TitleDataDto {

	/** ID */
	int id;

	/** タイトル */
	String title;

	/** タイトルかな */
	String title_kana;

	/** リリース媒体 */
	String media;

	/** リリース媒体テキスト */
	String media_text;

	/** リリース時期 */
	String season_name;

	/** リリース時期 (表記用) */
	String season_name_text;

	/** リリース日 */
	String released_on;

	/** 未確定な大体のリリース日 */
	String released_on_about;

	/** サイトURL */
	String official_site_url;

	/** ウィキペディアURL */
	String wikipedia_url;

	/** ツイッターユーザー名 */
	String twitter_username;

	/** ツイッターハッシュタグ */
	String twitter_hashtag;

	/** しょぼいカレンダーのタイトルID */
	String syobocal_tid;

	/** MyAnimeListの作品ID */
	String mal_anime_id;

//	/** タイトル */
//	String facebook_image_url;

	/** エピソード数 */
	int episodes_count;

	/** 見てる / 見たい / 見た人の数 */
	int watchers_count;

	/** レビュー数 */
	int reviews_count;

	/** エピソードが存在しない作品かどうか */
	boolean no_episodes;

}
