package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: department findBy ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
//		
//		System.out.println("\n==== TEST 2: department findByDepartment ====");
//		Department department = new Department(2,null);
//		List<Department> list = departmentDao.findByDepartment(department);
//		for (Department obj: list) {
//			System.out.println(obj);
//		}
//		
		System.out.println("\n==== TEST 3: department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department obj: list) {
			System.out.println(obj);
		}
//		
//		
		System.out.println("\n==== TEST 4: department insert ====");
		Department newDepartment = new Department(null, "Sports");
		departmentDao.insert(newDepartment);
		department = departmentDao.findById(newDepartment.getId());
		System.out.println("Inserted! new Id =  " + newDepartment.getId());
		System.out.println(department);
		
		
		System.out.println("\n==== TEST 5: department update ====");
		department = departmentDao.findById(3);
		department.setName("Fashion");
		departmentDao.update(department);
		System.out.println("Update completed! " + department);
		
		System.out.println("\n==== TEST 6: department delete ====");
		System.out.println("Enter id for delete test: ");
		int id =  sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
