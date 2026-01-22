package com.klu.app;

import com.klu.model.Department;
import com.klu.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.klu.util.HibernateUtil;

import java.util.Scanner;

public class MainApp {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("....main menu .....");
            System.out.println("select the choice:");
            System.out.println("1.insert the employee");
            System.out.println("2.display employee");
            System.out.println("3.update employee");
            System.out.println("4.delete employee");
            System.out.println("5.exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertEmployee(sc);
                    break;
                case 2:
                    displayEmployee(sc);
                    break;
                case 3:
                    updateEmployee(sc);
                    break;
                case 4:
                    deleteEmployee(sc);
                    break;
                case 5:
                    System.out.println("thankyou");
                    break;
                default:
                    System.out.println("wrong ");
            }

        } while (choice != 5);

        sc.close();
        factory.close();
    }


    static void insertEmployee(Scanner sc) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("enter dept name: ");
        String deptName = sc.next();

        System.out.print("enter the employee name: ");
        String empName = sc.next();

        System.out.print("enter employee salary: ");
        double salary = sc.nextDouble();

        Department dept = new Department();
        dept.setDeptName(deptName);

        Employee emp = new Employee();
        emp.setEmpName(empName);
        emp.setEmpSalary(salary);
        emp.setDepartment(dept);

        session.persist(dept);
        session.persist(emp);

        tx.commit();
        session.close();

        System.out.println("employee inserted successfully");
    }

    // -------- DISPLAY --------
    static void displayEmployee(Scanner sc) {

        Session session = factory.openSession();

        System.out.print("enter employee id: ");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            System.out.println("Name : " + emp.getEmpName());
            System.out.println("Salary : " + emp.getEmpSalary());
            System.out.println("Dept : " + emp.getDepartment().getDeptName());
        } else {
            System.out.println("Employee not found");
        }

        session.close();
    }

    private static void updateEmployee(Scanner sc) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("enter employee id: ");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            System.out.print("enter new salary: ");
            double salary = sc.nextDouble();
            emp.setEmpSalary(salary);

            tx.commit();   
            System.out.println("employee updated");
        } else {
            System.out.println("employee not found");
            tx.rollback(); 
        }

        session.close();  
    }

    
    private static void deleteEmployee(Scanner sc) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("enter employee id: ");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            session.delete(emp);
            tx.commit();
            System.out.println("employee deleted");
        } else {
            System.out.println("employee not found");
            tx.rollback();
        }

        session.close();
    }
}
