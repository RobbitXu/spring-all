package com.spring.common.utils;

import java.math.BigInteger;

/**
 * Created by admin on 2018/9/30.
 */
public class DecimalUtils {

    /**
     * 二进制转十进制
     * @param binarySource
     * @return
     */
    private static BigInteger binaryToDecimal(String binarySource){
        BigInteger bi = new BigInteger(binarySource, 2);
        return bi;
    }


    /**
     * 十进制转二进制
     * @param decimalSource
     * @return
     */
    private static String decimalToBinary(BigInteger decimalSource){
        return decimalSource.toString(2);
    }


    public static void main(String[] args) {
        System.out.println(binaryToDecimal("10000000000000000001"));
    }

}

