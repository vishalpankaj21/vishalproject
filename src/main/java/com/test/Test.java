package com.test;

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigDecimal;

class Employee {    
     long id;    
     String name;    
     Date dateOfBirth;    
     BigDecimal salary;    
    //Getter and Setters    
    // to String    
    @Override    
    public boolean equals(Object o) {        
        if (this == o) return true;        
        if (o == null || getClass() != o.getClass()) return false;        
        Employee employee = (Employee) o;        
        if (id != employee.id) return false;        
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;        
        if (dateOfBirth != null ? !dateOfBirth.equals(employee.dateOfBirth) : employee.dateOfBirth != null) return false;        
        return salary != null ? salary.equals(employee.salary) : employee.salary == null;    
    }    
    @Override    
    public int hashCode() {        
        int result = (int) (id ^ (id >>> 32));        
        result = 31 * result + (name != null ? name.hashCode() : 0);        
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;    
    }    
}

/* Name of the class has to be "Main" only if the class is public. */
class Test
{

public static void main(String[] args) {    
    HashMap<Employee,String> employeeMap = new HashMap<Employee,String>();  
    Employee employee1 = new Employee();  
    employee1.id=1;  
    employee1.name="Sachin";  
    employee1.dateOfBirth=new Date(1987,2,1);  
    employee1.salary = new BigDecimal(100000);
    // Step 1
    employeeMap.put(employee1,"India");  
    for (Map.Entry<Employee, String> employeeStringEntry : employeeMap.entrySet()) {
        System.out.println(employeeStringEntry.getKey().hashCode());  
    }
    // Step 2
    // Mutating the Employee Object
    employee1.name = "Rahul";    
    for (Map.Entry<Employee, String> employeeStringEntry : employeeMap.entrySet()) {
        System.out.println(employeeStringEntry.getKey().hashCode());
        System.out.println("*********>" + employeeStringEntry.getKey().equals(employee1));
    }
    // The HashMap key is mutated and in the wrong bucket for that hashcode.
    // Step 3
    System.out.println("1------------>" + employee1.hashCode());
    System.out.println(employeeMap.get(employee1));    
    // Returns null    
    Employee employee2 = new Employee();  
    employee2.id=1;  
    employee2.name="Sachin";  
    employee2.dateOfBirth=new Date(1987,2,1);  
    employee2.salary = new BigDecimal(100000);
    System.out.println("2------------->" + employee2.hashCode());
    System.out.println(employeeMap.get(employee2));
    // Returns null
    
    //step 4
	/*
	 * employee1.name = "Sachin"; System.out.println(employeeMap.get(employee1));
	 */ 
}
}
