package services;

import java.util.List;

import data.Product;

public interface ProductService {
	public List<Product> getInventory();
	public Product getProduct(int ID);
	public void addProduct(Product newProd);
	public Product editProduct(Product prod);
	public void deleteProduct(int ID);
	
	
	// getProductsByType
	// getProductsByCarton
	// getProductsByPallet
}
