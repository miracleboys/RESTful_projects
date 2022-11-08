package restful.entity;

public class Equivalent {

	private String name;//商品名
	private double price;//商品价格
	private int inventory;//库存
	
	public Equivalent(String name,double d,int inventory) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.price=d;
		this.inventory = inventory;
	}
	public Equivalent() { //构造函数
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	
}