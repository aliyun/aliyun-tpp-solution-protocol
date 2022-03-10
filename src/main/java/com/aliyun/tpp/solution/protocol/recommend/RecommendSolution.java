package com.aliyun.tpp.solution.protocol.recommend;

import com.aliyun.tpp.solution.protocol.Solution;
import com.aliyun.tpp.solution.protocol.SolutionProperties;
import com.aliyun.tpp.solution.protocol.SolutionContext;
import com.aliyun.tpp.solution.protocol.SolutionResult;

/**
 * 推荐方案执行入口类
 */
public interface RecommendSolution extends Solution {

    @Override
    default void init(SolutionProperties solutionProperties) {
    }

    @Override
    default SolutionResult execute(SolutionContext context) throws Exception {
        return recommend(context);
    }

    @Override
    default void destroy(SolutionProperties solutionProperties) {
    }

    /**
     * 推荐方案执行入口
     *
     * @param context 系统调用上下文，包含用户自定义参数
     * @return 推荐结果，不可以为null
     */
    RecommendResult recommend(SolutionContext context) throws Exception;
}
