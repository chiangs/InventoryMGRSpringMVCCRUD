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
	//	public Product(int iD, String brand, String type, String size, String batch, String qtyCarton, String qtyPallet, String image) {

	public void loadInventory() {
		inventory.clear();
		inventory.add(new Product(1,"Iskilde","still","33","2015-Jan","12","1596","/images/image.jpg"));
		inventory.add(new Product(2,"Iskilde","still","67","2016-Jan","12","1596","/images/image.jpg"));
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
		Product p = new Product();
		p.setID(inventory.get(inventory.size()-1).getID()+1);
		p.setBrand(newProd.getBrand());
		p.setType(newProd.getType());
		p.setSize(newProd.getSize());
		p.setBatch(newProd.getBatch());
		p.setQtyCarton(newProd.getQtyCarton());
		p.setQtyPallet(newProd.getQtyPallet());
		inventory.add(p);
	}

	@Override
	public List<Product> editProduct(Product prod) {

		int index = 0;
		for (Product product : inventory) {
			if (product.getID() == prod.getID()) {
				index = inventory.indexOf(product);
				break;
			}
		}
		Product p = inventory.get(index);
		p.setBrand(prod.getBrand());
		p.setType(prod.getType());
		p.setSize(prod.getSize());
		p.setBatch(prod.getBatch());
		p.setQtyCarton(prod.getQtyCarton());
		p.setQtyPallet(prod.getQtyPallet());
		return inventory;
	}

	@Override
	public void deleteProduct(Product prod) {
		inventory.remove(prod);
	}

}
