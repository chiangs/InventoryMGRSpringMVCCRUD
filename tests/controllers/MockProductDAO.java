package controllers;

import java.util.ArrayList;
import java.util.List;

import data.Product;
import data.ProductDAO;

public class MockProductDAO implements ProductDAO {

	List<Product> inventory;
	public MockProductDAO() {
		inventory = new ArrayList<>();
		loadInventory();
	}
	
	public void loadInventory() {
		inventory.clear();
		inventory.add(new Product(1,"Iskilde","still",33,"2015-Jan",12,1596));
		inventory.add(new Product(2,"Iskilde","still",67,"2016-Jan",12,1596));
	}

	@Override
	public List<Product> displayInventory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product displayProduct(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductByID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(Product newProd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product editProduct(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(int ID) {
		// TODO Auto-generated method stub
		
	}

}
