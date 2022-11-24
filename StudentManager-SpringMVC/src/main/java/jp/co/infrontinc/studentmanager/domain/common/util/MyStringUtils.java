package jp.co.infrontinc.studentmanager.domain.common.util;

import java.util.List;

/**
 * Stringユーティリティ
 * 
 * @author infront
 */
public class MyStringUtils {

	/**
	 * 値が空文字（""）やnullかを判別する
	 * 
	 *@param value
	 *@return nullまたは空文字（"")の場合はture。それ以外はfalse
	 */
	public static boolean isEmpty(String value) {
		
		if (value == null || "".equals(value) || "null".equals(value)) {
			
			return true;
		}
		return false;
	}
	
	/**
	 * 値が空文字（""）やnullではないかを判別する
	 * 
	 *@param value
	 *@return nullまたは空文字（"")ではない場合はtrue。それ以外はfalse
	 */
	public static boolean isNotEmpty(String value) {
		
		return !isEmpty(value);
	}
	
	/**
	 * 配列がnullかを判別する
	 * 
	 *@param value
	 *@return nullの場合はture。それ以外はfalse
	 */
	public static boolean isEmpty(String[] value) {
		
		if (value == null) {
			
			return true;
		}
		return false;
	}
	
	/**
	 * 配列がnullではないかを判別する
	 * 
	 *@param value
	 *@return nullではない場合はtrue。それ以外はfalse。
	 */
	public static boolean isNotEmpty(String[] value) {
		
		return !isEmpty(value);
	}
	
	/**
	 * リストがnullかを判別する
	 * 
	 *@param value
	 *@return nullの場合はture。それ以外はfalse
	 */
	public static boolean isEmpty( List<String> value) {
		
		if (value == null || value.size() == 0) {
			
			return true;
		}
		return false;
	}
	
	/**
	 * リストがnullではないかを判別する
	 * 
	 *@param value
	 *@return nullではない場合はtrue。それ以外はfalse。
	 */
	public static boolean isNotEmpty( List<String> value) {
		
		return !isEmpty(value);
	}
	
	/**
	 * 保持した値がnull文字の場合、空文字に変更する
	 * 
	 *@param value
	 *@return nullの場合は空文字。それ以外は値をそのまま返す。
	 */
	public static String nullToEmpty(String value) {
		
		if(value == null || "".equals(value) || "null".equals(value)) {
			
			return "";
		}
		
		return value;
	}
	
	/**
	 * 保持した値がnull文字の場合、任意の文字列に変更する
	 * 
	 *@param value
	 *@return nullの場合は空文字。それ以外は値をそのまま返す。
	 */
	public static String nullToMsg(String value , String msg) {
		
		if(value == null || "".equals(value) || "null".equals(value)) {
			
			return msg;
		}
		
		return value;
	}
	
	/**
	 * 保持した配列の値がnull文字の場合、空文字に変更する
	 * 
	 *@param value
	 *@return nullの場合は空文字。それ以外は値をそのまま返す。
	 */
	public static String[] nullToEmpty(String[] value) {
		
		if(value == null) {
			
			return new String[0];
		}
		
		return value;
	}
}
