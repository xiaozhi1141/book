package com.example.web;

import org.apache.commons.beanutils.BeanUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    // 获取ioc容器
    private static ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
    /**
     * 从ioc容器中获取组件
     * @param tClass
     * @param <T>
     * @return
     */
    public static  <T>T getBean(Class<T> tClass){
        return context.getBean(tClass);
    }
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
