package com.tang.tool;

public class StaticClassSinglton {

    private String name;
    //私有构造方法
    private StaticClassSinglton(){}
    //静态内部类创建对象
   static class SingltonHandler{
	private static StaticClassSinglton scs = new StaticClassSinglton();
    }
    //共有静态方法获取对象
    public static StaticClassSinglton getSinglton(){
	return SingltonHandler.scs;
	
    }
    
}
