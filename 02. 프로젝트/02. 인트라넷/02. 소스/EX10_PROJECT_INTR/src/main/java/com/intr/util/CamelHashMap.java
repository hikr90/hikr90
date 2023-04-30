package com.intr.util;

import java.util.HashMap;

import com.google.common.base.CaseFormat;

public class CamelHashMap extends HashMap {
	
	// 부모 클래스 HASHMAP의 PUT 오버라이딩  
	public Object put(Object key, Object value) {
		return super.put(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, (String)key), value);
	}
}
