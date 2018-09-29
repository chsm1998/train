package com.two.train.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: shop
 * @author: chsm
 * @create: 2018-09-05 09:46
 **/
@Data
@Accessors(chain = true)
public class MyPage {

    private Integer currPage;
    private Integer pageSize;

}
