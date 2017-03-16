package services;

import java.util.List;

import data.Product;

public interface ProductService {
	public List<Product> loadInventory();
	public List<Product> displayInventory();
	public Product displayProduct(int ID);
	public Product getProductByID();
	public void addProduct(Product newProd);
	public Product editProduct(int ID);
	public void deleteProduct(int ID);
	
	
	// getProductsByType
	// getProductsByCarton
	// getProductsByPallet
}
