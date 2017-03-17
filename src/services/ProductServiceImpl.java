package services;

import java.util.List;

import data.Product;
import data.ProductDAO;

public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}


	@Override
	public List<Product> getInventory() {
		return productDAO.getInventory();
	}

	@Override
	public Product getProduct(int ID) {
		return productDAO.getProduct(ID);
	}

	@Override
	public void addProduct(Product newProd) {
		productDAO.addProduct(newProd);
	}

	@Override
	public Product editProduct(Product prod) {
		return productDAO.editProduct(prod);
	}

	@Override
	public void deleteProduct(int ID) {
		Product p = productDAO.getProduct(ID);
		productDAO.deleteProduct(p);
	}
}
