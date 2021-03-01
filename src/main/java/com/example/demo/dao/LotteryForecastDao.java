package com.example.demo.dao;

import com.example.demo.pojo.LotteryPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author huazhd
 */

@Mapper

public interface LotteryForecastDao {
    /**
     * @return 历史二十期中奖记录
     */
    List<LotteryPojo> getHisTwentyData();
}
