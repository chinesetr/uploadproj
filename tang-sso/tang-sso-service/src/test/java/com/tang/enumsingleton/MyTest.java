package com.tang.enumsingleton;

import java.util.Date;

public class MyTest {

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

    public static void main(String[] args) {
	Amodel amodel = new Amodel();
	Bmodel bmodel = new Bmodel();
	new Thread(amodel).start();
	new Thread(bmodel).start();

    }
}

class Amodel implements Runnable {

    @Override
    public void run() {
	System.out.println(new Date().toString() + "Amodel开始执行");
	try {

	    synchronized (MyTest.obja) {
		System.out.println(new Date().toString() + "Amodel锁住obja");
		Thread.sleep(3000);
		// 获取objb
		synchronized (MyTest.objb) {
		    
		    System.out.println(new Date().toString() + "Amodel获得objb:" + MyTest.objb);
		}

	    }

	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
}

class Bmodel implements Runnable {

    @Override
    public void run() {

	try {
	    Thread.sleep(1000);
	    System.out.println(new Date().toString() + "Bmodel开始执行");
	    synchronized (MyTest.objb) {
	        System.out.println(new Date().toString() + "Bmodel锁住了objb");
	    }
	    // 获取obja
	    synchronized (MyTest.obja) {
		System.out.println(new Date().toString() + "Bmodel获得了obja:" + MyTest.obja);
	    }
	} catch (Exception e) {
	    // TODO Auto-generated catch block 
	    e.printStackTrace();
	}

    }

}
