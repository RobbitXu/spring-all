package com.spring.service;

/**
 * mysql 生成sequence
 * Created by admin on 2018/8/28.
 */
public interface MysqlSequence {

    /**
     * <p>
     * 获取指定sequence的序列号
     * </p>
     * @param  seqName sequence名
     * @return String 序列号
     */
    String nextVal(String seqName);
}
