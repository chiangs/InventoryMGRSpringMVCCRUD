package data;

public class Product {
	private int ID;
	private String brand;
	private String type;
	private String size;
	private String batch;
	private String qtyCarton;
	private String qtyPallet;
	private String image;
	
	public Product(){}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getQtyCarton() {
		return qtyCarton;
	}

	public void setQtyCarton(String qtyCarton) {
		this.qtyCarton = qtyCarton;
	}

	public String getQtyPallet() {
		return qtyPallet;
	}

	public void setQtyPallet(String qtyPallet) {
		this.qtyPallet = qtyPallet;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Product(int iD, String brand, String type, String size, String batch, String qtyCarton, String qtyPallet, String image) {
		super();
		ID = iD;
		this.brand = brand;
		this.type = type;
		this.size = size;
		this.batch = batch;
		this.qtyCarton = qtyCarton;
		this.qtyPallet = qtyPallet;
		this.image = image;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product ID=").append(ID).append(", Brand=").append(brand).append(", Flavor=").append(type)
				.append(", Size (cl)=").append(size).append(", Batch=").append(batch).append(", Qty pr Carton=")
				.append(qtyCarton).append(", Qty pr Pallet=").append(qtyPallet);
		return builder.toString();
	}
}
