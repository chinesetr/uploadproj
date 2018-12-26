package com.tang.tool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TangTest {

    public static void main(String[] args) {
	/*
	 * Singleton s1 = Singleton.getSingleton(); Singleton s2 =
	 * Singleton.getSingleton(); System.out.println(s1==s2);
	 * 
	 * Users u1 = new Users("zhang", "3221", 18);
	 * //System.out.println(u1.getName()); String ss =
	 * JsonUtils.BUNDLE.getString("KEYID"); System.out.println("ss:"+ss);
	 */

	/**
	 * map排序
	 */
	Map<String, Integer> p1 = new HashMap<String, Integer>();
	p1.put("a", 1);
	p1.put("f", 2);
	p1.put("e", 5);
	p1.put("d", 3);

	// 将map.entryset存入list中
	List<Map.Entry<String, Integer>> lst = new ArrayList<Map.Entry<String, Integer>>(p1.entrySet());
	//mySortedMethod(lst, "key");
	mySortedMethod(lst, "value");

    }

    public static void mySortedMethod(List<Map.Entry<String, Integer>> lst, String name) {
	// 使用集合工具类排序,Key升序
	Collections.sort(lst, new Comparator<Map.Entry<String, Integer>>() {

	    @Override
	    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
		// 判断name属性
		if ("key".equals(name)) {
		    // 升序
		    System.out.println(o1.getKey() + " ==== " + o2.getKey());
		    return ((o1.getKey()).compareTo(o2.getKey()));
		} else {
		    // 降序
		    System.out.println(o1.getValue() + " ==== " + o2.getValue());
		    return (o2.getValue().compareTo(o1.getValue()));
		}
	    }
	});

	// 排序后输出
	for (int i = 0; i < lst.size(); i++) {
	    String ss = lst.get(i).toString();
	    System.out.println(ss + " ");
	}
    }
}
