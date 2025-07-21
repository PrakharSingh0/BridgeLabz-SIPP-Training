package com.student;

public class Students {
    int id;
    String name;
    int age;
    
    public Students(int id,String name,int age) {
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public String toString()
    {
        return "ID:-"+id+" Name:-"+name+" age:-"+age;
    }
}
