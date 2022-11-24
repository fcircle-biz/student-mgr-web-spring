package jp.co.infrontinc.studentmanager.domain.common.code;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 性別コードマスタクラス.
 *
 * @author infront
 */
public class GenderCodeMaster {

	/** コードマップ */
	private Map<String,String> codeMap = new LinkedHashMap<String,String>();

	/**
	 * コンストラクタ
	 */
	public GenderCodeMaster() {

		codeMap.put("M","男性");
		codeMap.put("F","女性");
	}

	/**
	 * コードマップを取得する
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
	public String getValue(String genderCd) {
		return codeMap.get(genderCd);
	}
}