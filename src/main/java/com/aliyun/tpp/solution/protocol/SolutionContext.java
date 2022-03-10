package com.aliyun.tpp.solution.protocol;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * solution 每次执行期间传入执行上下文
 *
 * 生命周期: request 级别
 */
public interface SolutionContext extends Serializable {

    /**
     * 获取请求参数，没有则返回null
     */
    Object getRequestParams(String key);

    /**
     * 获取所有请求参数
     */
    Map<String, Object> getRequestParamsMapCopy();

    /**
     * 获取请求参数的所有key
     */
    default Set<String> requestParamsKeySet() {

        return Collections.emptySet();
    }

    /**
     * 获取所有AB配置项的key
     */
    default Set<String> abConfigKeySet() {

        return Collections.emptySet();
    }

    /**
     * 获取所有AB配置项
     */
    Map<String, Object> getAbConfigMapCopy();

    /**
     * 获取AB配置项信息
     *
     * @param key AB配置项的key
     * @return 对应AB配置项的value，没有则返回null
     */
    String getAbConfig(String key);

    /**
     * 获取当前方案日志
     */
    ContextLogger getContextLogger();

    /**
     * 获取当前执行的方案id
     */
    long getCurrentSolutionId();

    /**
     * 获取当前执行的场景id
     */
    long getCurrentAppId();

    /**
     * 获取当前执行的AB id
     */
    long getCurrentAbId();

    /**
     * 获取本次请求的唯一标识 就是为了包装getPvid
     */
    String getRequestId();

    /**
     * 获取场景超时时间
     */
    default long getTimeout() {

        return 0;
    }

    /**
     * 获取命中的桶号
     */
    default int getBucketId() {

        return 0;
    }
}
