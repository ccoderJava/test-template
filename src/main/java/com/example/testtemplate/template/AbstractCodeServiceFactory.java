package com.example.testtemplate.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 12:43
 */
public abstract class AbstractCodeServiceFactory<Provider extends CodeService> implements CodeServiceFactory<Provider> {

    protected Logger log = LoggerFactory.getLogger(getClass());

    private final Map<String, Provider> serviceProviderMap = new HashMap<>();

    public AbstractCodeServiceFactory(List<Provider> providers) {
        initializeProviderMap(providers);
    }

    /**
     * Initialize Factory Service
     *
     * @param providers 服务接口
     */
    private void initializeProviderMap(List<Provider> providers) {
        log.info("Initialize Factory Service:{}", getFactoryName());
        if (providers == null) {
            return;
        }
        for (Provider provider : providers) {
            String serviceCode = provider.getServiceCode();
            if (serviceCode == null) {
                throw new IllegalArgumentException(String.format("Registration service code cannot be empty :%s", provider.getClass()));
            }
            if (!serviceProviderMap.containsKey(serviceCode)) {
                serviceProviderMap.put(serviceCode, provider);
                log.info("Registered service: {}, {}", serviceCode, provider.getClass());
            } else {
                throw new IllegalArgumentException(String.format("Duplicate registration service: %s, %s, %s", serviceCode, serviceProviderMap.get(serviceCode).getClass(), provider.getClass()));
            }
        }
    }

    /**
     * 获取服务 服务接口不存在时返回null
     *
     * @param serviceCode 服务编码
     * @return 服务接口
     */
    @Override
    public Provider getService(String serviceCode) {
        return serviceProviderMap.get(serviceCode);
    }

    /**
     * 服务工厂名称
     *
     * @return 工厂名称用于日志
     */
    protected abstract String getFactoryName();
}
