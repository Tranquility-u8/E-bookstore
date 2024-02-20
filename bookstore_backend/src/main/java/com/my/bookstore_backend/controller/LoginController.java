package com.my.bookstore_backend.controller;

import com.my.bookstore_backend.entity.User;
import com.my.bookstore_backend.utils.msgutils.Msg;
import com.my.bookstore_backend.utils.msgutils.MsgCode;
import com.my.bookstore_backend.utils.msgutils.MsgUtil;
import com.my.bookstore_backend.utils.sessionutils.SessionUtil;
import com.my.bookstore_backend.constant.Constant;
import com.my.bookstore_backend.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.my.bookstore_backend.service.TimerService;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    private final TimerService timer;

    @Autowired
    public LoginController(TimerService timer) {
        this.timer = timer;
    }

    @RequestMapping("/login")
    public Msg login(@RequestBody Map<String, String> params){

        String username = params.get(Constant.USERNAME);
        String password = params.get(Constant.PASSWORD);

        User user = userService.checkUser(username, password);

        if(user != null){

            JSONObject obj = new JSONObject();
            obj.put(Constant.USER_ID, user.getUserId());
            obj.put(Constant.USERNAME, user.getUsername());
            obj.put(Constant.USER_TYPE, user.getUserType());
            SessionUtil.setSession(obj);

            JSONObject data = JSONObject.fromObject(user);
            data.remove(Constant.PASSWORD);

            timer.startTimer();

            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, data);
        }
        else{
            return MsgUtil.makeMsg(MsgCode.LOGIN_USER_ERROR);
        }
    }

    @RequestMapping("/logout")
    public Msg logout(@RequestBody Map<String, String> params){

        long duration = timer.stopTimer();

        Boolean status = SessionUtil.removeSession();

        String username = params.get(Constant.USERNAME);

        if(status){
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGOUT_SUCCESS_MSG + ",the session last " + duration + " s.");
        }
        return MsgUtil.makeMsg(MsgCode.ERROR, MsgUtil.LOGOUT_ERR_MSG);
    }

    @RequestMapping("/checkSession")
    public Msg checkSession(){
        JSONObject auth = SessionUtil.getAuth();

        if(auth == null){
            return MsgUtil.makeMsg(MsgCode.NOT_LOGGED_IN_ERROR);
        }
        else{
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.LOGIN_SUCCESS_MSG, auth);
        }
    }

}
