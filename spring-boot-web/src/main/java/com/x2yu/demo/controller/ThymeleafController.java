package com.x2yu.demo.controller;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Author: x2yu
 * @Date: 2019/8/14 16:55
 * @Describe：
 */

@Controller
public class ThymeleafController {

    @RequestMapping("/hi")
    public String helloTh(Locale locale, Model model){
        model.addAttribute("greeting","hello themeleaf!");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("currentTime", formattedDate);

        return "hello";
    }
}
