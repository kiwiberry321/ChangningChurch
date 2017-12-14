package com.shanghai.changning.controller;

import com.alibaba.fastjson.JSON;
import com.shanghai.changning.service.SundayAttendInfoService;
import com.shanghai.changning.utils.JsonUtil;
import com.shanghai.changning.vo.SundayAttendInfo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@Controller
@RequestMapping("/baseController")
public class baseController {

    @Autowired
    private SundayAttendInfoService sundayAttendInfoService;

    @RequestMapping("/test")
    public String test(){
        System.out.print("hhhhhh");
        return("deliveryNote");
    }

    @RequestMapping("/test1")
    public String test1(){
        System.out.print("hhhhhh");
        return("deliveryNote1");
    }

    @RequestMapping("/test4")
    public String test4(){
        System.out.print("4444");
        return("deliveryNote4");
    }

    public static void main(String[] args) {
        String a = "1234.66";
        String b = a.substring(0,a.indexOf("."));
        int len = b.length();
        System.out.println(b);
        String result = b.substring(len-3,len)+a.substring(a.indexOf("."), a.length());
        System.out.println(result);
    }

    @RequestMapping(value = "/saveInfo", method={RequestMethod.POST }, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String saveInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestJson = JsonUtil.getRequestJsonString(request);
        log.info(requestJson);
        SundayAttendInfo sundayAttendInfo = JSON.parseObject(requestJson,SundayAttendInfo.class);
        if (null!=sundayAttendInfo){
            //insert into DB
            sundayAttendInfoService.insert(sundayAttendInfo);
        }
        return null;
    }

}
