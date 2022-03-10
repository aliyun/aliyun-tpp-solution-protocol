/**
 * author: oe
 * date:   2022/2/7
 * comment:
 */
package com.aliyun.tpp.solution.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * 云上方案结果，返回格式如下
 * {
 * "data":{
 * "key":"value"
 * },
 * "_track_":{
 * "_request_id_": "376a473f-1d81**",//请求id，唯一
 * "_instance_":"TPP-CN-2xxxxx",//实例id
 * "_scene_id_":79,//场景id
 * "_ab_id_":90,//ab_id
 * "_bucket_":5,//桶号
 * "_trace_id_":"0a5306121****"//跟踪id，用于路径串联，过程诊断，可能为空（表示暂时不支持trace功能）
 * },//跟踪信息
 * <p>
 * }*/
public class SolutionResultSupport implements SolutionResult {
    //存储用户字段，不包含系统字段，最终会返回{"data":data}
    private Map<String, Object> data = new HashMap<String, Object>(4);

    @Override
    public void setAttribute(String key, Object value) {
        data.put(key,value);
    }

    @Override
    public Object getAttribute(String key) {
        return data.get(key);
    }

    @Override
    public Map<String, Object> getAllAttributes() {
        return data;
    }
}
