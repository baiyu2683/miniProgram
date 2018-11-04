package com.zh.controller;

import com.zh.common.Result;
import com.zh.common.ResultUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author zh2683
 */
@RestController
@RequestMapping({"/", "/home"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<String> home() {
        return ResultUtils.success();
    }
}
