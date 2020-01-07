package cn.qiandao.util;
import cn.qiandao.pojo.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @Description
 * @Author wt
 * @data
 */
@Component
public class CookieUtils {
    public String getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }


    public HttpServletResponse writeCookie(HttpServletResponse response, String cookieName, String value) {
        Cookie cookie = new Cookie(cookieName, value);
        //cookie.setPath("/");
        cookie.setMaxAge(5 * 60);
        response.addCookie(cookie);
        return response;
    }

}