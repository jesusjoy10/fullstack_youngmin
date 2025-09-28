package com.company.java011_ex;

public class ClassArrEx2 {
	 public static void main(String[] args) {
	        Apple[] apples = new Apple[3];
	        apples[0] = new Apple("RED", 1000);
	        apples[1] = new AppleGreen("GREEN", 2000);
	        apples[2] = new AppleRed("RED", 3000);
	        
	        for (Apple apple : apples) {
	            System.out.println(apple);
	        }
	    }
	}

	class Apple {
	    private String color;
	    private int price;
	    
	    public Apple(String color, int price) {
	        this.color = color;
	        this.price = price;
	    }
	    
	    public String toString() {
	        return "Apple[color=" + color + ", price=" + price + "]";
	    }
	}

	class AppleGreen extends Apple {
	    public AppleGreen(String color, int price) {
	        super(color, price);
	    }
	}

	class AppleRed extends Apple {
	    public AppleRed(String color, int price) {
	        super(color, price);
	    }
	}



