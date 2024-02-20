package com.my.bookstore_backend.interceptor;

import com.my.bookstore_backend.utils.msgutils.Msg;
import com.my.bookstore_backend.utils.msgutils.MsgCode;
import com.my.bookstore_backend.utils.msgutils.MsgUtil;
import com.my.bookstore_backend.utils.sessionutils.SessionUtil;
import net.sf.json.JSONObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import java.io.IOException;
import java.io.PrintWriter;

@Component
public class SessionValidateInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        boolean status = SessionUtil.checkAuth();
        if(!status){
            System.out.println("Check Auth Failed");
            Msg msg = MsgUtil.makeMsg(MsgCode.NOT_LOGGED_IN_ERROR);
            sendJsonBack(response, msg);
            return false;
        }
//        System.out.println("Success");
        return true;
    }

    private void sendJsonBack(HttpServletResponse response, Msg msg){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(JSONObject.fromObject(msg));
        } catch (IOException e) {
            System.out.println("send json back error");
        }
    }

}
