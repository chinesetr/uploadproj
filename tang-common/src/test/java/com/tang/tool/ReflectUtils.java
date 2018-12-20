package com.tang.tool;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectUtils<T> {

    public static void main(String[] args) {
	Users u1 = new Users("zhangsan", "128", 19);
	ReflectUtils<Users> reflectUtils = new ReflectUtils<Users>();
	 reflectUtils.reflectSetValue(u1,"name", "lisi");
	// reflectUtils.getValueByField("com.tang.tool.Users");
	/*Object ooo = reflectUtils.getValueByField("name", u1);
	System.out.println(ooo);*/
    }

    private Object getValueByField(String fieldname, Object obj) {
	try {
	    String firstChar = fieldname.substring(0, 1).toUpperCase();
	    String getter = "get" + firstChar + fieldname.substring(1);
	    Method method = obj.getClass().getMethod(getter, int.class);
	    Object value = method.invoke(obj, 23);
	    return value;
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}

    }

    private void getValueByField(String path) {
	try {
	    Class<?> clazz = Class.forName(path);
	    Object newinstance = clazz.newInstance();
	    Field[] fields = clazz.getDeclaredFields();
	    for (Field field : fields) {
		field.setAccessible(true);
		System.out.println("名字：" + field.getName() + " 值为：" + field.get(newinstance));
	    }
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    private void reflectSetValue(T t, String fieldname, String value) {
	try {
	    // Field field = obj.getClass().getDeclaredField(fieldname);
	    Field field = Users.class.getDeclaredField(fieldname);
	    System.out.println(field.getName());
	    // 设置字段为public
	    field.setAccessible(true);
	    // 设置对象的属性值
	    //field.set(t, value);
	    //System.out.println(((Users) t).getName());
	    System.out.println(field.getType()+" 我的obj:"+field.get(t));
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
