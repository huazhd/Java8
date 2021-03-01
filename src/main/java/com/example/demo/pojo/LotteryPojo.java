package com.example.demo.pojo;

import lombok.Data;

/**
 * @author ：hzd
 * @description：
 * @date ：2021/2/19 0019 16:11
 */
@Data
public class LotteryPojo {

    private String id;
    private String redOne;
    private String redTwo;
    private String redThree;
    private String redFour;
    private String redFive;
    private String redSix;

    private String blueOne;

    public LotteryPojo(String id, String redOne, String redTwo,
                       String redThree, String redFour,String redFive,
                       String redSix,String blueOne) {

        this.id = id;
        this.redOne = redOne;
        this.redTwo = redTwo;
        this.redThree = redThree;
        this.redFour = redFour;
        this.redFive = redFive;
        this.redSix = redSix;
        this.blueOne = blueOne;
    }
}
