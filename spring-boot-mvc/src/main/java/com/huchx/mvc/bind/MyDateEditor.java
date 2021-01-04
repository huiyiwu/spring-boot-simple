package com.huchx.mvc.bind;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyDateEditor extends PropertyEditorSupport {
    /**
     * 将时间戳字符串转为Date类型
     * @param text
     * @throws IllegalArgumentException
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Date(Long.decode(text)));
    }

    /**
     * 获取Date类型，转为字符串返回
     * @return
     */
    @Override
    public String getAsText() {
        Date date = (Date) getValue();
        return date==null?"": String.valueOf(TimeUnit.MILLISECONDS.toSeconds(date.getTime()));
    }
}
