package com.example.demo.controller;

import com.example.demo.pojo.LotteryPojo;
import com.example.demo.service.LotteryForecastService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hzd
 * @description：双色球中奖预测
 * @date ：2021/2/19 0019 15:50
 */
@RestController()
@RequestMapping("lottery")

public class LotteryForecastController {

    @Resource
    private LotteryForecastService lotteryFroecastService;

    @PostMapping("/getNextLotteryForecast")
    public List<LotteryPojo> getNextLotteryForecast(String method){
        List<LotteryPojo> nexLotteryList = new ArrayList<>();
        /**
         * @description：方法一：获取近20期数量最少的数据作为本期预测值
         * 每个号出现过，且出现次数最少的作为本期预测值
         * @author     ：hzd
         * @date       ：2021-02-19 15:54
         */
        try {
            nexLotteryList = lotteryFroecastService.getNextLotteryForecast(method);
        } catch (Exception e) {
            e.printStackTrace();
            return nexLotteryList;
        }
        return nexLotteryList;
    }
}
