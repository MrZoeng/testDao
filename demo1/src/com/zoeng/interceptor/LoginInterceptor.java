package com.zoeng.interceptor;

import com.zoeng.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Zoeng on 2021/4/7
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获得请求的url
        String url=request.getRequestURI();
        //url:除了login.jsp是可以公开访问的，其他的url都进行拦截控制
        if (url.indexOf("/login") >= 0) {
            return true;
        }
        //获得Session
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("USER_SESSION");

        //判断Session是否有用户数据，如果有，则返回true，继续向下执行
        if (user != null) {
            return true;
        }

        //不符合条件的给出提示信息，并转发到登录页面
        request.setAttribute("msg","您还没登录，请先登录");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
