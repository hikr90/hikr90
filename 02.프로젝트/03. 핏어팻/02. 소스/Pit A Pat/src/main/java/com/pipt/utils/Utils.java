package com.pipt.utils;

import javax.servlet.http.HttpServletRequest;

public class Utils {
	// IP 조회
	public static String getIp(HttpServletRequest request) {
		//--------------------------------------------------------------------------------------------
		// IP 조회
		//--------------------------------------------------------------------------------------------
        String ip = request.getHeader("X-Forwarded-For");
        //
        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        //
        return ip;
    }
}

