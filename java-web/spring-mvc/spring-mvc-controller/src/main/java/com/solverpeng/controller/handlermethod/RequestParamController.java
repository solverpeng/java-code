package com.solverpeng.controller.handlermethod;

import com.solverpeng.bean.Person;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/requestParam")
public class RequestParamController {

    // 默认是required
    @RequestMapping("/defaultRequired")
    public String requestParam(@RequestParam String petName) {
        return "requestParam->petName:" + petName;
    }

    /**
     * 自动类型转换
     */
    @RequestMapping("/autoTypeConversion")
    public String requestParam2(@RequestParam int age) {
        return "requestParam2->age:" + age;
    }

    // 同名数组或列表
    @RequestMapping("/arrayOrList")
    public String requestParam3(@RequestParam("name") String[] nameArray, @RequestParam("num") List<Integer> nums) {
        return "requestParam3->nameArray:" + Arrays.toString(nameArray) + ", nums:" + nums;
    }

    @RequestMapping("/map")
    public String requestParam4(@RequestParam Map<String, String> map) {
        return "requestParam4->map:" + map;
    }

    @RequestMapping("/map2")
    public String requestParam5(@RequestParam MultiValueMap<String, String> multiValueMap) {
        return "requestParam5->multiValueMap:" + multiValueMap;
    }

    // 不能通过Map接收单个参数，错误示例
    @RequestMapping("/map3")
    public String requestParam6(@RequestParam("name") MultiValueMap<String, String> multiValueMap) {
        return "requestParam6->multiValueMap:" + multiValueMap;
    }

    // 不能有多个Map参数，错误示例
    @RequestMapping("/map4")
    public String requestParam7(@RequestParam Map<String, String> map, @RequestParam MultiValueMap<String, String> multiValueMap) {
        return "requestParam7->map:" + map + ",multiValueMap:" + multiValueMap;
    }

    // 指定请求参数？
    @RequestMapping("/map5")
    public String requestParam8(@RequestParam("name") MultiValueMap<String, String> map) {
        return "requestParam8->map:" + map;
    }

    // Map中的List只能接收1个值
    @RequestMapping("/map6")
    public String requestParam9(@RequestParam Map<String, List<String>> map) {
        return "requestParam9->map:" + map;
    }

    // Map中的List可以接收多个值
    @RequestMapping("/map7")
    public String requestParam10(@RequestParam MultiValueMap<String, List<String>> map) {
        return "requestParam10->multiValueMap:" + map;
    }

    // 参数为日期
    @RequestMapping("/map8")
    public String requestParam11(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("from")LocalDate date) {
        return "requestParam10->date:" + date;
    }

    // 参数为对象
    @RequestMapping("/map9")
    public String requestParam12(Person person) {
        return "requestParam12->person:" + person;
    }
}
