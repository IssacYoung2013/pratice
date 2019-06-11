package com.issac.util;

import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author: ywy
 * @date: 2019-06-08
 * @desc:
 */
@Data
public class BeanFactory {

    private List<BeanDefined> beanDefinedList;

    private Map<String, Object> SpringIoc;//已经创建好的实例对象
    private BeanPostProcessor processorObj; // 后置对象

    /**
     * 依赖注入 就是反射
     *
     * @param instance
     * @param classFile
     * @param propertyMap
     */
    public void setValue(Object instance, Class classFile, Map propertyMap) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        // 循环遍历 propertyMap<属性名，属性值>
        Method methodArray[] = classFile.getDeclaredMethods();
        Set fieldNameSet = propertyMap.keySet();
        Iterator fieldIterator = fieldNameSet.iterator();
        while (fieldIterator.hasNext()) {
            String fieldName = (String) fieldIterator.next();
            String value = (String) propertyMap.get(fieldName);
            Field fieldObj = classFile.getDeclaredField(fieldName); // 同名的属性对象
            for (int i = 0; i < methodArray.length; i++) {
                Method methodObj = methodArray[i];
                String methodName = "set" + fieldName;
                if (methodName.equalsIgnoreCase(methodObj.getName())) {
                    Class fieldType = fieldObj.getType();// 属性的数据类型，Integer、String、Double、boolean、List
                    if (fieldType == String.class) {
                        methodObj.invoke(instance, value);
                    } else if (fieldType == Integer.class) {
                        methodObj.invoke(instance, Integer.valueOf(value));
                    } else if (fieldType == Boolean.class) {
                        methodObj.invoke(instance, Boolean.valueOf(value));
                    } else if (fieldType == List.class) {
                        List tempList = new ArrayList();
                        String dataArray[] = value.split(",");
                        for (int j = 0; j < dataArray.length; j++) {
                            tempList.add(dataArray[j]);
                        }
                        methodObj.invoke(instance, tempList);
                    } else {
                        // 此时类型是数组
                        String dataArray[] = value.split(",");
                        methodObj.invoke(instance, dataArray);
                    }
                }
            }
        }
    }

    public BeanFactory(List<BeanDefined> beanDefinedList) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.beanDefinedList = beanDefinedList;
        SpringIoc = new HashMap<>(); // 所有 scope = "singleton" 采用单例模式管理bean对象
        for (BeanDefined beanObj :
                beanDefinedList) {
            if ("singleton".equals(beanObj.getScope())) {
                Class classFile = Class.forName(beanObj.getClassPath());
                Object instance = classFile.newInstance();
                // 判断当前对象是一个bean对象还是后置处理对象
                isProcessor(instance, classFile);
                SpringIoc.put(beanObj.getBeanId(), instance);
            }
        }
    }

    private void isProcessor(Object instance, Class classFile) {
        Class interfaceArray[] = classFile.getInterfaces();
        if (interfaceArray == null) {
            return;
        }

        for (int i = 0; i < interfaceArray.length; i++) {
            Class interfaceType = interfaceArray[i];
            if (interfaceType == BeanPostProcessor.class) { // 证明当前的实例对象是后置处理器
                this.processorObj = (BeanPostProcessor) instance;
            }
        }
    }

    public Object getBean(String beanId) throws Exception {
        Object instance;
        Object proxyObj = null;
        for (BeanDefined beanObject : beanDefinedList) {
            if (beanId.equals(beanObject.getBeanId())) {
                String classPath = beanObject.getClassPath();
                Class classFile = Class.forName(classPath);
                String scope = beanObject.getScope();
                String factoryBean = beanObject.getFactoryBean();
                String factoryMethod = beanObject.getFactoryMethod();
                Map propertyMap = beanObject.getPropertyMap();
                if ("prototype".equals(scope)) {
                    // .getBean 每次都要返回一个全新的实例对象
                    if (factoryBean != null && factoryMethod != null) {
                        // 用户希望使用指定工厂创建实例对象
                        Object factoryObj = SpringIoc.get(factoryBean);
                        Class factoryClass = factoryObj.getClass();
                        Method methodObj =
                                factoryClass.getDeclaredMethod(factoryMethod, null);
                        methodObj.setAccessible(true);
                        instance = methodObj.invoke(factoryObj, null);
                    } else {
                        instance = classFile.newInstance();
                    }
                } else {
                    instance = SpringIoc.get(beanId);
                }
                // 在默认情况下，Spring工厂调用当前类默认工作方法创建实例对象
//                instance = classFile.newInstance();
                if (this.processorObj != null) {
//                    实例对象初始化注入
                    proxyObj = this.processorObj.postProcessBeforeInitialization(instance, beanId);
                    setValue(instance,classFile,propertyMap);
                    proxyObj = this.processorObj.postProcessAfterInitialization(instance, beanId);
                    // 此时返回proxyObj可能就是原始bean对象，也有可能就是代理对象

                    return proxyObj;
                } else {
                    // 实例对象初始化
                    setValue(instance,classFile,propertyMap);
                    return instance;
                }
            }
        }
        return null;
    }
}
