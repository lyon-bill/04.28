package util;

import javax.servlet.http.Cookie;

/**
 * 抽取的是获取Cookie的类 CookieUtil
 * 
 * @author 疯人院酋长专属机
 *
 */
public class CookieUtil {
	public static Cookie getCookies(Cookie[] cookies, String key) {
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (key != null && key.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}
}
