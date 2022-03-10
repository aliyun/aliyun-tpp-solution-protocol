package com.aliyun.tpp.solution.protocol;


/**
 * 输出用户方案日志
 */
public interface ContextLogger {

    void info(String log);

    void warn(String log);

    void error(String log, Throwable t);

}
