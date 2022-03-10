package com.aliyun.tpp.solution.protocol.recommend;

import com.aliyun.tpp.solution.protocol.SolutionResult;

import java.util.Collections;
import java.util.List;

/**
 * 推荐方案执行结果。结构样例如下
 * * {
 * "data":{
 * "result":[],
 * "empty":false,
 * "${key}":${value}
 * }
 * }
 */
public interface RecommendResult extends SolutionResult {

    String RESULT_KEY = "result";//推荐结果 $data.result=List<Object>

    String EMPTY_KEY = "empty";//推荐是否空结果

    @Override
    default void setAttribute(String key, Object value) {
        if (key.equals(RESULT_KEY)) {
            throw new IllegalArgumentException(key + " not allowed as keyword!!");
        }
        if (key.equals(EMPTY_KEY)) {
            throw new IllegalArgumentException(key + " not allowed as keyword!!");
        }
        getAllAttributes().put(key, value);
    }

    @Override
    default Object getAttribute(String key) {
        return getAllAttributes().get(key);
    }

    /**
     * 获取推荐结果集
     */
    default List<Object> getRecommendResult() {
        return (List<Object>) getAllAttributes().getOrDefault(RESULT_KEY, Collections.emptyList());
    }

    /**
     * 设置推荐结果集
     */
    default void setRecommendResult(List<? extends Object> result) {
        getAllAttributes().put(RESULT_KEY, result);
    }

    /**
     * 允许用户自定义 业务空结果
     */
    default boolean isEmpty() {
        return (boolean) getAllAttributes().getOrDefault(EMPTY_KEY, false);
    }

    /**
     * 允许用户自定义 业务空结果
     * @param empty 标记本次结果是否为业务空结果, 可用于监控, 或者便于兜底结果
     */
    default void setEmpty(boolean empty) {
        getAllAttributes().put(EMPTY_KEY, empty);
    }
}
