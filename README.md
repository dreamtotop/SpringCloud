# SpringCloud


package org.top.api;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
//        String person_card = "101";
//        long card = Long.parseLong(person_card,8);
        //String card = String.valueOf(Long.parseLong(person_card,16)).substring(0,8);
        //System.out.println(card);

//        Date date = new Date();
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        System.out.println(date);
//        System.out.println(cal.getTime());
//        String format = "yyyy-MM-dd HH:mm:ss";
//        SimpleDateFormat fmt = new SimpleDateFormat(format);
//        System.out.println(fmt.format(cal.getTime()));

        try {
            Map returnMap = new HashMap();
            UserDTO demo = UserDTO.class.newInstance();
            demo.setId(1);
            demo.setGender(20);
            demo.setName("hello");
            Class type = demo.getClass();
            System.out.println(demo.getClass().toString());
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            System.out.println(beanInfo);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(int i = 0; i <propertyDescriptors.length; i++){
                System.out.println(propertyDescriptors[i]);
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    System.out.println(readMethod.toString());
                    Object result = readMethod.invoke(demo);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    } else {
                        returnMap.put(propertyName, null);
                    }
                }
            }
            System.out.println(returnMap.toString());
            System.out.println(type.getDeclaredField("id").getName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}


package org.top.api;
import java.io.Serializable;
public class UserDTO implements Serializable {

    private Integer id;
    private String name;
    private Integer gender;

    public UserDTO() {

    }

    public UserDTO(Integer id, String name, Integer gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public UserDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UserDTO setGender(Integer gender) {
        this.gender = gender;
        return this;
    }
}
