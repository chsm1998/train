package com.two.train.vo;

import com.two.train.common.MyPage;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: train
 * @author: chsm
 * @create: 2018-10-08 09:54
 **/
@Data
@Accessors(chain = true)
public class SiteVo {

    private String siteName;
    private MyPage myPage;

}
