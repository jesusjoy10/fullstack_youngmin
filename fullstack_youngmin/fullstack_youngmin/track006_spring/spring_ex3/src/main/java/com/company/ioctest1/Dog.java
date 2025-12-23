package com.company.ioctest1;

import lombok.Data;

@Data
public class Dog  implements Animal{
    @Override public String eat() { return "Dog-eat"; }
    @Override public String sleep() { return "Dog-sleep"; }
    @Override public String poo() { return "Dog-poo"; }
 } 
