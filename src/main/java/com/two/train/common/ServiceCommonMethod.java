package com.two.train.common;

/**
 * @program: shop
 * @author: chsm
 * @create: 2018-09-05 09:16
 **/
public class ServiceCommonMethod {

    public static ServerResponse<String> returnInsert(int count, String success, String error) {
        if (count == 1) {
            return ServerResponse.createSuccessMessage(success);
        }
        return ServerResponse.createErrorMessage(error);
    }

}
