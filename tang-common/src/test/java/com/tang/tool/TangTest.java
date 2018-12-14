package com.tang.tool;


public class TangTest {

    public static void main(String[] args) {
	Singleton s1 = Singleton.getSingleton();
	Singleton s2 = Singleton.getSingleton();
	System.out.println(s1==s2);

	Users u1 = new Users("zhang", "3221", 18);
	System.out.println(u1.getName());
	String ss = JsonUtils.BUNDLE.getString("KEYID");
	System.out.println("ss:"+ss);
    }

}
