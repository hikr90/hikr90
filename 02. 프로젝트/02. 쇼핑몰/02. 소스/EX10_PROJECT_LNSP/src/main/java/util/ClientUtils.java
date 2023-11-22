package util;

import javax.servlet.http.HttpServletRequest;

public class ClientUtils {
	// 아이피주소 가져오기 Common.getIp(request)
    public static String getIp(HttpServletRequest request) {
    	
        String ip = request.getHeader("X-Forwarded-For");
 
        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
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
 
        return ip;
 
    }
}

