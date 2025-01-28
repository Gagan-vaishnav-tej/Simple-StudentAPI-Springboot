package com.project.StudentAPI;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue
    Integer id;

    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    Integer age;
    @Column(nullable = false)
    String city;
    @Column(nullable = false)
    Float cpga;

    public Student() {
    }

    public Student(String name, Integer age, String city, Float cpga) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.cpga = cpga;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", cpga=" + cpga +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Float getCpga() {
        return cpga;
    }

    public void setCpga(Float cpga) {
        this.cpga = cpga;
    }


}
