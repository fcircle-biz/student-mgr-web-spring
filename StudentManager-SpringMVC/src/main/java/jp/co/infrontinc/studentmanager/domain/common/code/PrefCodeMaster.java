package jp.co.infrontinc.studentmanager.domain.common.code;

import java.util.LinkedHashMap;
import java.util.Map;

import jp.co.infrontinc.studentmanager.domain.common.util.MyNumberUtils;

/**
 * 都道府県コードマスタクラス.
 *
 * @author infront
 */
public class PrefCodeMaster {

	/** コードマップ */
	private Map<Integer,String> codeMap = new LinkedHashMap<>();

	/**
	 * コンストラクタ.
	 */
	public PrefCodeMaster() {

		codeMap.put(1,"北海道");
		codeMap.put(2,"青森県");
		codeMap.put(3,"岩手県");
		codeMap.put(4,"宮城県");
		codeMap.put(5,"秋田県");
		codeMap.put(6,"山形県");
		codeMap.put(7,"福島県");
		codeMap.put(8,"茨城県");
		codeMap.put(9,"栃木県");
		codeMap.put(10,"群馬県");
		codeMap.put(11,"埼玉県");
		codeMap.put(12,"千葉県");
		codeMap.put(13,"東京都");
		codeMap.put(14,"神奈川県");
		codeMap.put(15,"新潟県");
		codeMap.put(16,"富山県");
		codeMap.put(17,"石川県");
		codeMap.put(18,"福井県");
		codeMap.put(19,"山梨県");
		codeMap.put(20,"長野県");
		codeMap.put(21,"岐阜県");
		codeMap.put(22,"静岡県");
		codeMap.put(23,"愛知県");
		codeMap.put(24,"三重県");
		codeMap.put(25,"滋賀県");
		codeMap.put(26,"京都府");
		codeMap.put(27,"大阪府");
		codeMap.put(28,"兵庫県");
		codeMap.put(29,"奈良県");
		codeMap.put(30,"和歌山県");
		codeMap.put(31,"鳥取県");
		codeMap.put(32,"島根県");
		codeMap.put(33,"岡山県");
		codeMap.put(34,"広島県");
		codeMap.put(35,"山口県");
		codeMap.put(36,"徳島県");
		codeMap.put(37,"香川県");
		codeMap.put(38,"愛媛県");
		codeMap.put(39,"高知県");
		codeMap.put(40,"福岡県");
		codeMap.put(41,"佐賀県");
		codeMap.put(42,"長崎県");
		codeMap.put(43,"熊本県");
		codeMap.put(44,"大分県");
		codeMap.put(45,"宮崎県");
		codeMap.put(46,"鹿児島県");
		codeMap.put(47,"沖縄県");
	}

	/**
	 * コードマップを取得する.
	 *
	 * @return コードマップ
	 */
	public Map<Integer, String> getMap() {
		return codeMap;
	}

	/**
	 * 値を取得する.
	 *
	 * @param key キー
	 * @return 値
	 */
	public String getValue(Integer prefId) {
		return codeMap.get(prefId);
	}
	
	/**
	 * 値を取得する.
	 *
	 * @param key キー
	 * @return 値
	 */
	public String getValue(String prefId) {
		return codeMap.get(MyNumberUtils.IntValueOf(prefId));
	}
}