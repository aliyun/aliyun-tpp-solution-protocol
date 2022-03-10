package com.aliyun.tpp.solution.protocol;

import java.io.Serializable;
import java.util.Map;

/**
 * 方案执行结果。结构样例如下
 * <pre>
 * {
 * "data":{"${key}":${value}}
 * }
 * </pre>
 */
public interface SolutionResult extends Serializable {

    /**
     * 设置一个 attribute <pre><key-value/></pre>
     */
    void setAttribute(String key, Object value);

    /**
     * 获取一个 attribute 的值
     *
     * @return value
     */
    Object getAttribute(String key);

    /**
     * 获取所有attributes
     *
     * @return Map<key, value>
     */
    Map<String, Object> getAllAttributes();
}
