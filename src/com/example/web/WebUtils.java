package com.example.web;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    /**
     * 把Map中的值注入到对应的javabean属性中
     * @param values
     * @param bean
     */
    public  static <T> T copyParamToBean(Map values, T bean){
        try {
            BeanUtils.populate(bean,values);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
