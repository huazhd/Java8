package com.example.demo.service.impl;

import com.example.demo.dao.LotteryForecastDao;
import com.example.demo.pojo.LotteryPojo;
import com.example.demo.service.LotteryForecastService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author ：hzd
 * @description：预测实现类
 * @date ：2021/2/19 0019 15:59
 */
@Service
public class LotteryForecastServiceImpl implements LotteryForecastService {
    @Resource
    public LotteryForecastDao lotteryForecastDao;

    Map<String,Long> redOneMap = null;
    Map<String,Long> redTwoMap = null;
    Map<String,Long> redThreeMap = null;
    Map<String,Long> redFourMap = null;
    Map<String,Long> redFiveMap = null;
    Map<String,Long> redSixMap = null;
    Map<String,Long> blueOneMap = null;

    Map<String, Long> sortRedOneMapByCount =null;
    Map<String, Long> sortRedTwoMapByCount =null;
    Map<String, Long> sortRedThreeMapByCount =null;
    Map<String, Long> sortRedFourMapByCount =null;
    Map<String, Long> sortRedFiveMapByCount =null;
    Map<String, Long> sortRedSixMapByCount =null;
    Map<String, Long> sortBlueOneMapByCount =null;

    String redOne = null;
    String redTwo = null;
    String redThree = null;
    String redFour = null;
    String redFive = null;
    String redSix = null;
    String blueOne = null;
    @Override
    public List<LotteryPojo> getNextLotteryForecast(String method) {
        List<LotteryPojo> lotteryList = new ArrayList<>();
        List<LotteryPojo> lotteryForecastList = new ArrayList<>();
        //获取近20期历史双色球中奖数据
        lotteryList = lotteryForecastDao.getHisTwentyData();
        /*lotteryList.add(new LotteryPojo("1","2","3","9","11","12","18","7"));
        lotteryList.add(new LotteryPojo("2","3","5","5","14","7","18","7"));
        lotteryList.add(new LotteryPojo("3","3","5","9","14","12","12","2"));*/
        //判断不为空才执行后续计算
        if(!CollectionUtils.isEmpty(lotteryList)){
            //将数据转换为map
            transformationMap(lotteryList,"redOne");
            transformationMap(lotteryList,"redTwo");
            transformationMap(lotteryList,"redThree");
            transformationMap(lotteryList,"redFour");
            transformationMap(lotteryList,"redFive");
            transformationMap(lotteryList,"redSix");
            transformationMap(lotteryList,"blueOne");
            //统计map中No的值以及每个值出现的次数
            sortedByCount("redOneMap");
            sortedByCount("redTwoMap");
            sortedByCount("redThreeMap");
            sortedByCount("redFourMap");
            sortedByCount("redFiveMap");
            sortedByCount("redSixMap");
            sortedByCount("blueOneMap");
            //获取出现次数最少的值作为本次开奖的redOne预测值
            getForecastKey();
            LotteryPojo lotteryPojo = new LotteryPojo("1",redOne,
                    redTwo,redThree,redFour,redFive,redSix,blueOne);
            lotteryForecastList.add(lotteryPojo);
        }
        lotteryForecastList.forEach(System.out::println);
        return lotteryForecastList;
    }

    /**
     * @description：TODO 获取map第一个元素的Key
     * @author     ：hzd
     * @date       ：2021-03-01 16:19
     */
    private void getForecastKey() {
        for(Map.Entry<String, Long> map:sortRedOneMapByCount.entrySet()){
            redOne=map.getKey();
            break;
        }
        for(Map.Entry<String, Long> map:sortRedTwoMapByCount.entrySet()){
            redTwo=map.getKey();
            break;
        }
        for(Map.Entry<String, Long> map:sortRedThreeMapByCount.entrySet()){
            redThree=map.getKey();
            break;
        }
        for(Map.Entry<String, Long> map:sortRedFourMapByCount.entrySet()){
            redFour=map.getKey();
            break;
        }
        for(Map.Entry<String, Long> map:sortRedFiveMapByCount.entrySet()){
            redFive=map.getKey();
            break;
        }
        for(Map.Entry<String, Long> map:sortRedSixMapByCount.entrySet()){
            redSix=map.getKey();
            break;
        }
        for(Map.Entry<String, Long> map:sortBlueOneMapByCount.entrySet()){
            blueOne=map.getKey();
            break;
        }
    }
    /**
     * @description：TODO 排序
     * @author     ：hzd
     * @date       ：2021-03-01 16:19
     */
    private void sortedByCount(String map) {
        switch (map){
            case "redOneMap":
                sortRedOneMapByCount = redOneMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
                break;
            case "redTwoMap":
                sortRedTwoMapByCount = redTwoMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
                break;
            case "redThreeMap":
                sortRedThreeMapByCount = redThreeMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
                break;
            case "redFourMap":
                sortRedFourMapByCount = redFourMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
                break;
            case "redFiveMap":
                sortRedFiveMapByCount = redFiveMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
                break;
            case "redSixMap":
                sortRedSixMapByCount = redSixMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
                break;
            case "blueOneMap":
                sortBlueOneMapByCount = blueOneMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + map);
        }

    }

    /**
     * @description：TODO 对历史数据进行次数统计
     * @author     ：hzd
     * @date       ：2021-03-01 16:20
     */
    private void transformationMap( List<LotteryPojo> lotteryList, String no) {
        switch (no){
            case "redOne":
                redOneMap = lotteryList.stream().map(LotteryPojo::getRedOne).
                        collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                break;
            case "redTwo":
                redTwoMap = lotteryList.stream().map(LotteryPojo::getRedTwo).
                        collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                break;
            case "redThree":
                redThreeMap = lotteryList.stream().map(LotteryPojo::getRedThree).
                        collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                break;
            case "redFour":
                redFourMap = lotteryList.stream().map(LotteryPojo::getRedFour).
                        collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                break;
            case "redFive":
                redFiveMap = lotteryList.stream().map(LotteryPojo::getRedFive).
                        collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                break;
            case "redSix":
                redSixMap = lotteryList.stream().map(LotteryPojo::getRedSix).
                        collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                break;

            case "blueOne":
                blueOneMap = lotteryList.stream().map(LotteryPojo::getBlueOne).
                        collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + no);
        }


    }
}
