package com.huchx.json.strategy;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.huchx.json.annotation.GsonTransparent;

public class GsonTransparentStrategy implements ExclusionStrategy {
    /**
     * 如果注解@GsonTransparent存在排除该字段
     * @param fieldAttributes
     * @return
     */
    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return fieldAttributes.getAnnotation(GsonTransparent.class)!=null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return aClass.getAnnotation(GsonTransparent.class)!=null;
    }
}
