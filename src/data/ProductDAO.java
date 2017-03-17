package data;

import java.util.List;

public interface ProductDAO {
	public List<Product> getInventory();
	public Product getProduct(int ID);
	public void addProduct(Product newProd);
	public List<Product> editProduct(Product prod);
	public void deleteProduct(Product prod);
	
	
	// getProductsByType
	// getProductsByCarton
	// getProductsByPallet
}