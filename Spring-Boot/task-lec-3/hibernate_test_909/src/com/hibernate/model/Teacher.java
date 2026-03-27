package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {

	@Column(name="id")
	@Id
	private Integer id;
	@Column(name="name",length = 50,nullable = false,unique = true)
    private String name;
	private String age;
	@Column(unique = true)
    private String address;
public Teacher() {
	
}
public Teacher(Integer id, String name, String age, String address) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.address = address;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "Teacher [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
}

}
