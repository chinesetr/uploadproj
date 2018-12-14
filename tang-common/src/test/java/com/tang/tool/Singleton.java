package com.tang.tool;

public class Singleton {

    //私有够着方法
    private Singleton() {
    };
   private static Singleton ss=new Singleton();
    // 公有静态方法获取实例
    public static Singleton getSingleton() {
	return ss;
    }

}
