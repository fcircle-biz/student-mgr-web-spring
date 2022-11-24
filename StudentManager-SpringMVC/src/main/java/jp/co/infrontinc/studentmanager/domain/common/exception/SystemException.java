package jp.co.infrontinc.studentmanager.domain.common.exception;

/**
 * 軽量システム例外クラス
 * 
 * @author infront
 */
public class SystemException extends RuntimeException{

	/**
	 * コンストラクタ
	 * 
	 * @param clazz エラーが発生したクラス
	 * @param message メッセージ
	 * @param cause Exception
	 */
	public SystemException(Class<?> clazz, String message, Throwable cause) {
		super(clazz.getSimpleName() + ":" + message, cause);
	}
	
	/**
	 * コンストラクタ
	 * 
	 * @param clazz エラーが発生したクラス
	 * @param messageId メッセージID
	 */
	public SystemException(Class<?> clazz, String message) {
		super(clazz.getSimpleName() + ":" + message);
	}
	
	
	
}
