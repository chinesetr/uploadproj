package com.tang.tool;


public class FileInput{

    public static void main(String[] args){
	int[] num = {1,12,3,17,8,9};
	int temp = 0;
	for (int i = 0; i < num.length-1; i++) {
	    for(int j=0;j<num.length-i-1;j++){
		if(num[j]>num[j+1]){
		  temp=num[j];
		  num[j]=num[j+1];
		  num[j+1]=temp;
		}
	    }
	    
	}
	
	for (int i : num) {
	    System.out.println(i);
	}
	
    }
}

