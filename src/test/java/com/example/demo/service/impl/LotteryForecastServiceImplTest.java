package com.example.demo.service.impl;

import com.example.demo.BaseAppTest;
import com.example.demo.dao.LotteryForecastDao;
import com.example.demo.pojo.LotteryPojo;
import com.example.demo.service.LotteryForecastService;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LotteryForecastServiceImplTest extends BaseAppTest {
    @Resource
    private LotteryForecastService lotteryForecastService;

    @Test
    void getNextLotteryForecastMethod1(){
        lotteryForecastService.getNextLotteryForecast("1");
    }

    @Test
    void getNextLotteryForecast() {
        List<LotteryPojo> lotteryList = new ArrayList<>();
        //获取近20期历史双色球中奖数据
        // lotteryList = lotteryForecastDao.getHisTwentyData();
        lotteryList.add(new LotteryPojo
                ("1","2","3","9","11","12","18","7"));
        lotteryList.add(new LotteryPojo
                ("2","3","5","9","14","12","18","7"));
        lotteryList.add(new LotteryPojo
                ("3","3","5","9","14","12","18","7"));
        //判断不为空才执行后续计算
        if(!CollectionUtils.isEmpty(lotteryList)){
            //将数据转换为map
            Map<String,Long> redOneMap = lotteryList.stream().map(s->s.getRedOne())
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
            //统计map中redOne的值以及每个值出现的次数
            final Map<String, Long> sortedByCount = redOneMap.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey,
                            Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            //获取出现次数最少的值作为本次开奖的redOne预测值
            String redOneForecast = null;
            for(Map.Entry<String,Long> map:sortedByCount.entrySet()){
                redOneForecast = map.getKey();
            }
            System.out.println(redOneForecast);
        }
    }
}