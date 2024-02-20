package com.my.bookstore_backend.serviceimpl;

import com.my.bookstore_backend.service.TimerService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TimerServiceImpl implements TimerService  {

    private Long start_time;

    public void startTimer() {
        start_time = System.currentTimeMillis();
        System.out.println(start_time);
    }

    public long stopTimer() {
        System.out.println(start_time);
        if (start_time != null) {
            Long end_time = System.currentTimeMillis();
            long duration = (end_time - start_time) / 1000;
            this.start_time = 0L;
            System.out.println("The session lasts " + duration + " s.");
            return duration;
        } else {
            return 0;
        }
    }
}