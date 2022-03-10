package com.aliyun.tpp.solution.protocol;

/**
 * 用户方案
 */
public interface Solution {

    /**
     * 方案初始化，只会在对象实例化之后调用一次
     *
     * @return
     */
    void init(SolutionProperties properties);

    /**
     * 方案执行入口
     *
     * @param context
     * @return
     * @throws Exception
     */
    SolutionResult execute(SolutionContext context) throws Exception;

    /**
     * 方案销毁，只会在方案卸载时执行一次
     */
    void destroy(SolutionProperties properties);

}
