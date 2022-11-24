package jp.co.infrontinc.studentmanager.domain.common.util;

import java.util.Date;

import jp.co.infrontinc.studentmanager.domain.student.model.Counter;

public class MySQLUtils {
	
	public static String setUpdate(StringBuilder sql, String col, String value, Counter counter) {
		
		if(MyStringUtils.isEmpty(value)) {
			return null;
		}
		if(counter.getCount() == 0) {
			sql.append(" SET");
		} else {
			sql.append(" ,");
		}
		sql.append(" " + col + "='" + value + "'");
		counter.setCount(counter.getCount() + 1);
		
		return sql.toString();
	}
	
	public static String setUpdate(StringBuilder sql, String col, Integer value, Counter counter) {
		
		if(MyNumberUtils.isEmpty(value)) {
			return null;
		}
		
		if(counter.getCount() == 0) {
			sql.append(" SET");
		} else {
			sql.append(" ,");
		}
		sql.append(" " + col + "=" + value);
		counter.setCount(counter.getCount() + 1);
	
		return sql.toString();
	}
	
	public static String setUpdate(StringBuilder sql, String col, Date value, Counter counter) {
		
		if(value == null) {
			return null;
		}
		if(counter.getCount() == 0) {
			sql.append(" SET");
		} else {
			sql.append(" ,");
		}
		sql.append(" " + col + "='" + value + "'");
		counter.setCount(counter.getCount() + 1);
		
		return sql.toString();
	}
}
