package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		
		SellerDao sellerDao = DaoFactory.createSellerDao();		
		
		System.out.println("---TEST 1: Seller findById---");
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.printf("\n---TEST 2: Seller findByDepartment---\n");
		Department dep = new Department(2, null);
		List<Seller>list = sellerDao.findByDepartment(dep);
		
		for (Seller obj  : list) {
			System.out.println(obj);
		}
		
		System.out.printf("\n---TEST 3: Seller findAll---\n");
		
		list = sellerDao.findAll();
		
		for (Seller obj  : list) {
			System.out.println(obj);
		}
		
		System.out.printf("\n---TEST 4: Seller Insert---\n");
		
		Seller newSeller = new Seller(null, "Greg", "greg@bol.com.br", new Date(), 4000.00, dep);
		
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted! New id = " + newSeller.getId());
		
	}

}
