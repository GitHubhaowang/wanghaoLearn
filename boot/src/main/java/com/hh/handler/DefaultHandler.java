package com.hh.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO
 *
 * @author hh
 * @version 1.0
 * @date 2021/3/13
 */
@Controller
public class DefaultHandler {

    @ResponseBody
    @RequestMapping(value = "/")
    public String start() {
        return "启动了。。。";
    }

    @ResponseBody
    @RequestMapping(value = "/test1")
    public String test1() {
        return "test1";
    }

    @ResponseBody
    @RequestMapping(value = "/test2")
    public String test2() {
        return "test2";
    }
}
