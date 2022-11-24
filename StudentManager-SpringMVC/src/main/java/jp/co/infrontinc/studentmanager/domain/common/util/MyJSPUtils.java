package jp.co.infrontinc.studentmanager.domain.common.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MyJSPUtils {
	
	/**
	 * テキストボックスの生成
	 * 
	 * @param name name属性
	 * @param value value属性（初期値となる値）
	 * @return 初期値が設定されている場合は初期値を挿入済み
	 * 			未設定の場合は空のテキストボックス
	 */
	public static String renderText(String name, String value) {
		
		if (value == null || "null".equals(value)) {
			value = "";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<input type=\"text\" name=" + name + " value=\"" + value + "\">");
		return sb.toString();
	}
	
	/**
	 * テキストボックスの生成（試用）
	 * 
	 * @param name name属性
	 * @param value value属性（初期値となる値）
	 * @return 初期値が設定されている場合は初期値を挿入済み
	 * 			未設定の場合は空のテキストボックス
	 */
	public static String renderText2(String name, String value) {
		
		if (value == null || "null".equals(value)) {
			value = "";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<input type=\"text\" required name=" + name + " value=\"" + value + "\">");
		return sb.toString();
	}
	
	/**
	 * セレクトボックスの生成
	 * 
	 * @param name name属性
	 * @param selected（初期値となる値）
	 * @return 初期値が設定されている場合は初期値の項目を選択済み
	 * 			未設定の場合は未選択状態のセレクトボックス
	 */
	public static String renderSelect(String name, Map<Integer,String> map, String selected) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<select name=" + name + ">");
		sb.append("<option value=\"\">（選択してください）</option>");
		
		for (int key : map.keySet()) {
			
			sb.append("<option value=\"" + key + "\"");
			
			if(selected != null && selected.equals(String.valueOf(key))) { 
				sb.append("selected");
			}
			sb.append(">" + map.get(key) + "</option>");
		}
		sb.append("</select>");
		
		return sb.toString();
	}
	
	/**
	 * セレクトボックスの生成（試用）
	 * 
	 * @param name name属性
	 * @param selected（初期値となる値）
	 * @return 初期値が設定されている場合は初期値の項目を選択済み
	 * 			未設定の場合は未選択状態のセレクトボックス
	 */
	public static String renderSelect2(String name, Map<Integer,String> map, String selected) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<select required name=" + name + ">");
		sb.append("<option value=\"\">（選択してください）</option>");
		
		for (int key : map.keySet()) {
			
			sb.append("<option value=\"" + key + "\"");
			
			if(selected != null && selected.equals(String.valueOf(key))) { 
				sb.append("selected");
			}
			sb.append(">" + map.get(key) + "</option>");
		}
		sb.append("</select>");
		
		return sb.toString();
	}
	
	/**
	 * セレクトボックスの生成（年齢）
	 * 
	 * @param name name属性
	 * @param selected（初期値となる値）
	 * @param start 選択肢の最小数値
	 * @param end 選択肢の最大数値
	 * @return 初期値が設定されている場合は初期値の項目を選択済み
	 * 			未設定の場合は未選択状態のセレクトボックス
	 */
	public static String renderSelect(String name, int start, int end, String selected) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<select name=" + name + ">");
		sb.append("<option value=\"\">（選択してください）</option>");
		
		for (int i = start; i <= end; i++) {
			
			sb.append("<option value=\"" + i + "\"");
			
			if(selected != null && selected.equals(String.valueOf(i))) { 
				sb.append("selected");
			}
			sb.append(">" + i + "歳</option>");
		}
		sb.append("</select>");
		
		return sb.toString();
	}
	
	/**
	 * ラジオボタンの生成
	 * 
	 * @param name name属性
	 * @param checked（初期値となる値）
	 * @return 初期値が設定されている場合は初期値の項目を選択済み
	 * 			未設定の場合は未選択状態のラジオボタン
	 */
	public static String renderRadio(String name, Map<String,String> map, String checked) {
		
		StringBuilder sb = new StringBuilder();
		
		for(String key : map.keySet()) {
			
			sb.append("<input id=\"" +  key + "\" type=\"radio\" name=" + name + " value=\"" + key + "\"");
			
			if(checked != null && checked.equals(key)) {
				sb.append("checked");
			}
			sb.append("><label for=\"" + key + "\">" + map.get(key) + "</label>");
		}
		return sb.toString();
	}
	
	/**
	 * 日付型テキストボックスの生成
	 * 
	 * @param name name属性
	 * @param value value属性（初期値となる値）
	 * @return 初期値が設定されている場合は初期値を表示
	 * 			未設定の場合は未選択状態の日付型テキストボックス
	 */
	public static String renderDate(String name, String value) {
		
		if (value == null) {
			value = "";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<input type=\"date\" name=" + name + " value=\"" + value + "\">");
		
		return sb.toString();
	}
	
	/**
	 * チェックボックスの生成
	 * 
	 * @param name name属性
	 * @param checked（初期値となる値）
	 * @return 初期値が設定されている場合は初期値の項目を選択済み
	 * 			未設定の場合は未選択状態のチェックボックス
	 */
	public static String renderCheckbox(String name, Map<String,String> map, String[] checked) {
		
		StringBuilder sb = new StringBuilder();
		
		for(String key : map.keySet()) {
			
			sb.append("<input id=\"" +  key + "\" type=\"checkbox\" name=" + name + " value=\"" + key + "\"");
			
			if(checked != null && Arrays.asList(checked).contains(key)) {
				sb.append("checked");
			}
			sb.append("><label for=\"" +  key + "\">" + map.get(key) + "</label>");
		}
		return sb.toString();
	}
	
	/**
	 * チェックボックスの生成
	 * 
	 * @param name name属性
	 * @param checked（初期値となる値）
	 * @return 初期値が設定されている場合は初期値の項目を選択済み
	 * 			未設定の場合は未選択状態のチェックボックス
	 */
	public static String renderCheckbox(String name, Map<String,String> map, List<String> checked) {
		
		StringBuilder sb = new StringBuilder();
		
		for(String key : map.keySet()) {
			
			sb.append("<input id=\"" +  key + "\" type=\"checkbox\" name=" + name + " value=\"" + key + "\"");
			
			if(checked != null && checked.contains(key)) {
				sb.append("checked");
			}
			sb.append("><label for=\"" +  key + "\">" + map.get(key) + "</label>");
		}
		return sb.toString();
	}
	
	
	public static String renderHidden(String name, String value) {
		
		if (value == null) {
			value = "";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<input type=\"hidden\" name=" + name + " value=\"" + value + "\">");
		return sb.toString();
	}
	
	public static String renderHidden(String name, String[] value) {
		
		if (value != null) {
			
			StringBuilder sb = new StringBuilder();
			for (String subjectCd : value) {
				sb.append("<input type=\"hidden\" name=" + name + " value=\"" + subjectCd + "\">");
			}
			return sb.toString();
			
		} else {
			
			return "";
		}
	}
}