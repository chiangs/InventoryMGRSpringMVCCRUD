package data;

import java.util.List;

public interface ProductDAO {
	public void loadInventory();
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
