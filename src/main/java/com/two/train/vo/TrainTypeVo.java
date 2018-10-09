package com.two.train.vo;

import com.two.train.common.MyPage;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: train
 * @author: chsm
 * @create: 2018-10-09 15:47
 **/
@Data
@Accessors(chain = true)
public class TrainTypeVo {

    private String trainType;
    private MyPage myPage;

}
