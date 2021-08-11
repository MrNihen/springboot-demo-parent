package com.niihen.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * @Description
 * @Author zhuguanglong
 * @Company
 * @Date 2021/08/04 17:37
 */
@Controller
public class FreemarkerDemoTest {

//   @RequestMapping("/freemarker")
//   @ResponseBody
//   public String freemarkerTest(Model model) {
//
//        //4.执行模板处理器
//        //4.1)定义数据模型
//        Map dataModel = new HashMap<>();
//        dataModel.put("name", "张三");
//        dataModel.put("message", "欢迎学习Freemarker模板技术！");
////        model.addAllAttributes("dataModel",dataModel);
//        model.addAttribute(dataModel);
//        //4.2)定义一组List<Map>对象
//        Map map1 = new HashMap();
//        map1.put("id", 1001);
//        map1.put("fname", "苹果");
//        map1.put("price", 10);
//        map1.put("num", 5);
//        Map map2 = new HashMap();
//        map2.put("id", 1002);
//        map2.put("fname", "桔子");
//        map2.put("price", 5);
//        map2.put("num", 3);
//        Map map3 = new HashMap();
//        map3.put("id", 1003);
//        map3.put("fname", "香蕉");
//        map3.put("price", 3);
//        map3.put("num", 5);
//
//        model.addAttribute(map1);
//        model.addAttribute(map2);
//        model.addAttribute(map3);
//        List<Map> mapList = new ArrayList<>();
//        mapList.add(map1);
//        mapList.add(map2);
//        mapList.add(map3);
//
//        model.addAttribute(mapList);
//        model.addAttribute("list",mapList);
////        dataModel.put("list", mapList);
//
//        model.addAttribute("today",new Date());
//        //4.3)定义一个日期变量
//        dataModel.put("today", new Date());
//
//        model.addAttribute("point",123456789);
////        //4.4)定义数字类型
////        dataModel.put("point", 12345678);
//
//        return "test";
//    }

    @RequestMapping("/hello")
    @ResponseBody
    public String index(Map<String,String> map){
        map.put("name","hello freemarker!");
        return "index";
    }


}
