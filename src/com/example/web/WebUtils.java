package com.example.web;

import org.apache.commons.beanutils.BeanUtils;
import org.omg.CORBA.PUBLIC_MEMBER;

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

    /**
     * 将字符串转化为int类型
     * @param strInt
     * @param defaultValue
     * @return
     */

    public static int parseInt(String strInt, int defaultValue  ){
        try{
            return Integer.parseInt(strInt);

        } catch (Exception e){
            return defaultValue;
        }
    }
}
