package com.common.utils;

/**
 * @Author: donnie99
 * @Date: 2020/6/17 23:20
 * @Version 1.0
 */
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonUtils {
    public JsonUtils() {
    }

    public static String renderString(HttpServletResponse response, Object object) {
        return renderString(response, JsonMapper.toJsonString(object), "application/json");
    }

    public static String renderString(HttpServletResponse response, String string, String type) {
        try {
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
            return null;
        } catch (IOException var4) {
            return null;
        }
    }
}