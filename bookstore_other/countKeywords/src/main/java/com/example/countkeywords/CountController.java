package com.example.countkeywords;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.hadoop.shaded.org.eclipse.jetty.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

@RestController
public class CountController {

    @Autowired
    CountService countService;

    @RequestMapping("/countKeywords")
    public void countKeywords(@RequestParam("keyword") String keyword){
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {}.getType();
        List<String> keyword_ = gson.fromJson(keyword, listType);
        System.out.println(keyword_);
        //List<String> list = Arrays.asList("Java", "JavaScript", "C++", "Programming", "Star", "Robot");
        countService.countKeywords("input", keyword_);
    }
}
