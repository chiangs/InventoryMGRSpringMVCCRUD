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
	public List<Product> getInventory() {
		List<Product> userInv = new ArrayList<>(inventory);
		return userInv;
	}

	@Override
	public Product getProduct(int ID) {
		Product p = null;
		for (Product product : inventory) {
			if (product.getID() == ID) {
				p = product;
				break;
			}
		}
		return p;
	}

	@Override
	public void addProduct(Product newProd) {
		inventory.add(newProd);
	}

	@Override
	public Product editProduct(Product prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Product prod) {
		inventory.remove(prod);
	}

}
