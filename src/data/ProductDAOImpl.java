package data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class ProductDAOImpl implements ProductDAO {
	private static final String FILE_NAME = "/WEB-INF/inventory.csv";
	private List<Product> products = new ArrayList<>();
	
	@Autowired
	private WebApplicationContext wac;

	@Override
	public List<Product> loadInventory() {
		// TODO Auto-generated method stub
		return null;
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
