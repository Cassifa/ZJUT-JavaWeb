package zjut.lff.homework5;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/*
 * @ Author     ：Li Feifei
 * @ Date       ：Created in 1:17 2024/4/11
 * @ Description：Session工具类
 */
public class SessionUtil {
    public static boolean isValid(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        //未登录
        if (session == null) return false;
        // 更新Session的最大非活动时间间隔为半小时
        session.setMaxInactiveInterval(30 * 60); // 半小时
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID") && cookie.getValue().equals(session.getId())) {
                    // 更新Cookie的最大生存时间为半小时
                    cookie.setMaxAge(30 * 60); // 半小时
                    return true;
                }
            }
        }
        return false;
    }
}
