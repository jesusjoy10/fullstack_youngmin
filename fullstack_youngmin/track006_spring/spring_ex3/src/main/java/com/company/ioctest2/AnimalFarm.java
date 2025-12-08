package com.company.ioctest2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("animalFarm")
public class AnimalFarm {
	@Value("${name}")
	private String name;
	//@Autowired  @Qualifier(name="${ani}")  private Aniaml ani;
	@Resource(name="${ani}") 
	private Animal ani;
  
 
    public AnimalFarm() { super(); }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Animal getAni() { return ani; }
    public void setAni(Animal ani) { this.ani = ani; }
 
    public String aniSleep() { return name + ">" + ani.sleep(); }
    public String aniEat()   { return name + ">" + ani.eat(); }
    public String aniPoo()   { return name + ">" + ani.poo(); }
 
    public void print() { 
       System.out.println(  aniSleep()); 
       System.out.println(  aniEat()); 
       System.out.println(  aniPoo()); 
    }

 }
