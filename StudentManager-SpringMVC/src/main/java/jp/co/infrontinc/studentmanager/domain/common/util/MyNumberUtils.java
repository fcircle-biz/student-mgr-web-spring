package jp.co.infrontinc.studentmanager.domain.common.util;

public class MyNumberUtils {

	/**
	 * 値が空文字（""）やnullかを判別する
	 * 
	 *@param value
	 *@return nullまたは空文字（"")の場合はture。それ以外はfalse
	 */
	public static boolean isEmpty(Integer value) {
		
		if (value == null || value == 0) {
			
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
	public static boolean isNotEmpty(Integer value) {
		
		return !isEmpty(value);
	}
	
	/**
	 * String型からInteger型へ変換
	 * 
	 * @param String value
	 * @return Integer intVal
	 */
	public static Integer IntValueOf(String value) {
		
		if(MyStringUtils.isEmpty(value)) {
			return null;
		}
		
		return Integer.valueOf(value);
	}
}
