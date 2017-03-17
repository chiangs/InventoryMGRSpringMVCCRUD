package data;

public class Product {
	private int ID;
	private String brand;
	private String type;
	private int size;
	private String batch;
	private int qtyCarton;
	private int qtyPallet;
	
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public int getQtyCarton() {
		return qtyCarton;
	}

	public void setQtyCarton(int qtyCarton) {
		this.qtyCarton = qtyCarton;
	}

	public int getQtyPallet() {
		return qtyPallet;
	}

	public void setQtyPallet(int qtyPallet) {
		this.qtyPallet = qtyPallet;
	}

	public Product(int iD, String brand, String type, int size, String batch, int qtyCarton, int qtyPallet) {
		super();
		ID = iD;
		this.brand = brand;
		this.type = type;
		this.size = size;
		this.batch = batch;
		this.qtyCarton = qtyCarton;
		this.qtyPallet = qtyPallet;
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
