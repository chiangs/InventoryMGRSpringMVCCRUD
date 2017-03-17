package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class ProductDAOImpl implements ProductDAO {
	private static final String FILE_NAME = "/WEB-INF/inventory.csv";
	private List<Product> inventory = new ArrayList<>();

	@Autowired
	private WebApplicationContext wac;

	/*
	 * The @PostConstruct method is called by Spring after object creation and
	 * dependency injection
	 */

	@PostConstruct
	public void init() {
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				int id = Integer.parseInt(tokens[0]);
				String brand = tokens[1];
				String type = tokens[2];
				int size = Integer.parseInt(tokens[3]);
				String batch = tokens[4];
				int qtyCarton = Integer.parseInt(tokens[5]);
				int qtyPallet = Integer.parseInt(tokens[6]);
				inventory.add(new Product(id, brand, type, size, batch, qtyCarton, qtyPallet));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
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
		for (Product product : inventory) {
			System.out.println(product);
		}
		return inventory;
	}

	@Override
	public void deleteProduct(Product prod) {
		inventory.remove(prod);
	}

}