package jp.co.infrontinc.studentmanager.domain.common.code;

import java.util.LinkedHashMap;
import java.util.Map;

import jp.co.infrontinc.studentmanager.domain.common.util.MyNumberUtils;

/**
 * 性別コードマスタクラス.
 *
 * @author infront
 */
public class AgeCodeMaster {

	/** コードマップ */
	private Map<Integer,String> codeMap = new LinkedHashMap<>();

	/**
	 * コンストラクタ
	 */
	public AgeCodeMaster() {

		codeMap.put(12,"12歳");
		codeMap.put(13,"13歳");
		codeMap.put(14,"14歳");
		codeMap.put(15,"15歳");
		codeMap.put(16,"16歳");
		codeMap.put(17,"17歳");
		codeMap.put(18,"18歳");
	}

	/**
	 * コードマップを取得する
	 *
	 * @return コードマップ
	 */
	public Map<Integer,String> getMap() {
		return codeMap;
		
	}
	
	/**
	 * 値を取得する.
	 *
	 * @param key キー
	 * @return 値
	 */
	public String getValue(Integer age) {
		return codeMap.get(age);
	}
	
	/**
	 * 値を取得する.
	 *
	 * @param key キー
	 * @return 値
	 */
	public String getValue(String age) {
		return codeMap.get(MyNumberUtils.IntValueOf(age));
	}
}