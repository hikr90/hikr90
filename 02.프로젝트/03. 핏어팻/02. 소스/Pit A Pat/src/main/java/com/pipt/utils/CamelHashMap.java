package com.pipt.utils;

import java.util.HashMap;
import com.google.common.base.CaseFormat;

public class CamelHashMap extends HashMap {
	//
	public Object put(Object key, Object value) {
		return super.put(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, (String)key), value);
	}
}
