package com.thejoa703.ioc;

//@Data
public class DITest1 {
	private String name;
	private int age;
	
	
	public DITest1() { super();  }
	public DITest1(String name, int age) { super(); this.name = name; this.age = age; }
	
	@Override public String toString() { return "DITest [name=" + name + ", age=" + age + "]"; }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//생성자 + toString + getters/setters
	
	

}
