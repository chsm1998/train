package com.two.train.vo;

import com.two.train.common.MyPage;
import com.two.train.entity.User;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: train
 * @author: chsm
 * @create: 2018-09-29 09:41
 **/
@Data
@Accessors(chain = true)
public class UserVo {

    private String username;
    private MyPage myPage;

}
