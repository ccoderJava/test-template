package com.example.testtemplate.request;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2023/3/6 11:38
 */
public class AbstractRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 扩展参数
     */
    private Map<String, String> extension;


    public boolean containsExtension(String key) {
        if (extension == null) {
            return false;
        } else {
            return extension.containsKey(key);
        }
    }

    public String getExtension(String key) {
        if (extension == null) {
            return null;
        } else {
            return extension.get(key);
        }
    }

    public void putExtension(String key, String value) {
        if (this.extension == null) {
            this.extension = new HashMap<>();
        }
        this.extension.put(key, value);
    }

    public Map<String, String> getExtension() {
        return extension;
    }

    public void setExtension(Map<String, String> extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }


}
