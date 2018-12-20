package com.tang.enumsingleton;

public enum EnumSingleton {

    INSTANCE;
    //想要获得的单例对象
    private Example example1;
    //构造方法
    private EnumSingleton(){
	example1 = new Example();
	System.out.println("enum单利模式");
    }
    //获取单例对象
    public Example getInstance(){
	return example1;
    }
    
}
