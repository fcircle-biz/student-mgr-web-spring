package jp.co.infrontinc.studentmanager.domain.common.code;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 教科コードマスタクラス.
 *
 * @author infront
 */
public class SubjectCodeMaster {

	/** コードマップ */
	private Map<String,String> codeMap = new LinkedHashMap<String,String>();

	/**
	 * コンストラクタ.
	 */
	public SubjectCodeMaster() {

		codeMap.put("MA", "数学");
		codeMap.put("JA", "国語");
		codeMap.put("EN", "英語");
	}

	/**
	 * コードマップを取得する.
	 *
	 * @return コードマップ
	 */
	public Map<String,String> getMap() {

		return codeMap;
	}
	
	/**
	 * 値を取得する.
	 *
	 * @param key キー
	 * @return 値
	 */
	public String getValue(String subjectCd) {
		return codeMap.get(subjectCd);
	}
}
