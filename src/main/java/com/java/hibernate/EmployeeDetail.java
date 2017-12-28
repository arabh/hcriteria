package com.java.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class EmployeeDetail {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Transaction tr = null;
		Session session = null;
		try {
			Configuration cfg = new Configuration().configure();
			sf = cfg.buildSessionFactory();
			session = sf.openSession();
			tr = session.beginTransaction();			
		} catch (Exception e) {
			e.getMessage();
		}
		 Employee e1 = new Employee(101, "Thor", 12000);
		 Employee e2 = new Employee(103, "BatMan", 10000);
		 Employee e3 = new Employee(104, "Hulk", 14000);
		 session.save(e1);
		 session.save(e2);
		 session.save(e3);		 
		 tr.commit();	
		 
		 
		 @SuppressWarnings("deprecation")
		Criteria cr = session.createCriteria(Employee.class);
		 cr.add(Restrictions.eq("empName", "Hulk"));
		 List employees = cr.list();
		 
		 Iterator iterator = employees.iterator(); 
		 while(iterator.hasNext()){
	            Employee employee = (Employee) iterator.next(); 
	            System.out.print("Id: " + employee.getEmpId()); 
	            System.out.print("  Name: " + employee.getEmpName()); 
	            System.out.println("  Salary: " + employee.getSalary()); 
	         }
		 
		
		 session.close();
		 
		 
		 	 

	}

}
