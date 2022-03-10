package com.aliyun.tpp.solution.protocol;

/**
 * solution 属性原来叫LifeCycleConfig
 *
 * 在方案生命周期变更时, 提供对内部不可变属性的访问
 *
 */
public interface SolutionProperties {

    /**
     * 获取场景id
     */
    default long getAppId() {
        return 0;
    }

    /**
     * 获取方案id
     */
    default long getSolutionId() {
        return 0;
    }

}
