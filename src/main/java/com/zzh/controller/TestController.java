package com.zzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Aurora
 * @Date 2021/1/8 13:25
 * @Version 1.0
 */

@Controller
public class TestController {

    @GetMapping("/test/t1")
    public ModelAndView test1() {
        return new ModelAndView("/test");
    }

    @GetMapping("/test/t2")
    @ResponseBody
    public Map<String, String> test2() {
        Map<String, String> result = new HashMap<String, String>();
        result.put("test", "测试文本");
        return result;
    }
}
