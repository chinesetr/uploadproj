package com.tang.enumsingleton;

import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MyTest2 {

    // public static void main(String[] args) {
    // Example ex1 = new Example();
    // Example ex2 = new Example();
    // Example ex3 = EnumSingleton.INSTANCE.getInstance();
    // Example ex4 = EnumSingleton.INSTANCE.getInstance();
    // System.out.println(ex1==ex2);
    // System.out.println(ex3==ex4);

    /*
     * int[] tes = {1,2,3}; //System.out.println(tes[0]+"  "+tes.length);
     * 
     * for (int i = 0; i < tes.length; i++) { System.out.println(tes[i]); }
     */

    public static String obja = "a元素";
    public static String objb = "b元素";
    public static final Semaphore sm1 = new Semaphore(1);
    public static final Semaphore sm2 = new Semaphore(1);

    public static void main(String[] args) {
	ModelA amodel = new ModelA();
	ModeB bmodel = new ModeB();
	new Thread(amodel).start();
	new Thread(bmodel).start();

    }
}

class ModelA implements Runnable {

    @Override
    public void run() {
	System.out.println(new Date().toString() + "ModelA开始执行");
	try {

	    /*synchronized (MyTest2.obja) {
		System.out.println(new Date().toString() + "ModelA锁住obja");
		Thread.sleep(3000);
		// 获取objb
		synchronized (MyTest2.objb) {
		    
		    System.out.println(new Date().toString() + "ModelA获得objb:" + MyTest2.objb);
		}

	    }*/
	    if(MyTest2.sm1.tryAcquire(1, TimeUnit.SECONDS)){
		
		System.out.println(new Date().toString()+"  "+Thread.currentThread().getName()+"获取了obja:"+MyTest2.obja);
		TimeUnit.SECONDS.sleep(3);
		
		if(MyTest2.sm2.tryAcquire(10, TimeUnit.SECONDS)){
		    System.out.println(new Date().toString()+"  "+Thread.currentThread().getName()+"获取了objb:"+MyTest2.objb);
		    Thread.sleep(3000);
		}else{
		    System.out.println(new Date().toString()+"  "+Thread.currentThread().getName()+"获取objb失败！！！");
		}
	    }else{
		System.out.println(new Date().toString()+"  "+Thread.currentThread().getName()+"获取obja失败！！！");
		
	    }
	    MyTest2.sm1.release();
	    MyTest2.sm2.release();

	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
}

class ModeB implements Runnable {

    @Override
    public void run() {

	try {
	    //Thread.sleep(1000);
	    TimeUnit.SECONDS.sleep(3);
	    System.out.println(new Date().toString() + "ModeB开始执行");
	    /*synchronized (MyTest2.objb) {
	        System.out.println(new Date().toString() + "ModeB锁住了objb");
	        // 获取obja
	        synchronized (MyTest2.obja) {
	            System.out.println(new Date().toString() + "ModeB获得了obja:" + MyTest2.obja);
		}
	    }*/
	    
	    if(MyTest2.sm2.tryAcquire(1, TimeUnit.SECONDS)){
		System.out.println(new Date().toString()+"  "+Thread.currentThread().getName()+"获取了objb:"+MyTest2.objb);
		Thread.sleep(3);
		
		if(MyTest2.sm1.tryAcquire(10, TimeUnit.SECONDS)){
		    System.out.println(new Date().toString()+"  "+Thread.currentThread().getName()+"获取了obja:"+MyTest2.obja);
		    Thread.sleep(3);
		}else{
		    System.out.println(new Date().toString()+"  "+Thread.currentThread().getName()+"获取obja失败！！！");
		}
	    }else{
		System.out.println(new Date().toString()+"  "+Thread.currentThread().getName()+"获取objb失败！！！");
	    }
	    MyTest2.sm2.release();
	    MyTest2.sm1.release();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
