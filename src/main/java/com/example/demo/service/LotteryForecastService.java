package com.example.demo.service;

import com.example.demo.pojo.LotteryPojo;

import java.util.List;

/**
 * @author huazhd
 */
public interface LotteryForecastService {

    List<LotteryPojo> getNextLotteryForecast(String method);
}
