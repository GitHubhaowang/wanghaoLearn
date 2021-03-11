package com.hh.springboot.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hh
 * @email wanghao1@szkingdom.com
 * @date 2021/3/10
 */
@Controller
public class TestHandler {

    @ResponseBody
    @RequestMapping(name="/ceshi", value = "/ceshi")
    public String test(HttpServletRequest request) {
        return "xxxxxxxxxxxx";
    }
}
