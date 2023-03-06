package com.example.testtemplate.template;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 12:43
 */
public interface CodeServiceFactory<Provider> {
    /**
     * 获取服务
     *
     * @param serviceCode 服务编码
     * @return 返回服务，不存在时返回null
     */
    Provider getService(String serviceCode);
}
