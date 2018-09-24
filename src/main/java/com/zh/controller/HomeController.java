package com.zh.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zh.common.Result;
import com.zh.common.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author zh2683
 */
@RestController
@RequestMapping({"/", "/home"})
public class HomeController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<String> home() {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("123");
        redisTemplate.opsForList().leftPushAll("list", list);
        List<Date> dates  = new ArrayList<>();
        dates.add(new Date());
        dates.add(new Date());
        redisTemplate.opsForList().leftPushAll("arr", dates);
        Object date = redisTemplate.opsForList().leftPop("arr");
        Date date1 = JSONObject.toJavaObject((JSON) JSON.parse(String.valueOf(date)), Date.class);
        System.out.println(date1);
        return ResultUtils.success();
    }
}
