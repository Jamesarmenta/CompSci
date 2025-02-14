public class Item implements Comparable<Item>{
	
	private String item;
	private double price;
	private int quantity;
	
	public Item(){ //Default input
		item = "Student";
		price = 0;
		quantity = 0;
	}
	
	public Item(String item, double price, int quantity)
	{
		this.item = item;
		setPrice(price);
		setQuantity(quantity);
	}
	
	public void setPrice(double price)
	{
		if (price >= 0 && price <= 10000)
		{
			this.price = price;
		}
		else
		{
			this.price = 0; //if price is outside of 0-10000, set as 0
		}
	}
	
	public void setQuantity(int quantity)
	{
		if (quantity >= 0 && quantity <= 10000)
		{
			this.quantity = (int)quantity;
		}
		else
		{
			this.quantity = (int)0;
		}
	}

	public String toString()
	{
		return item + " " + price + " " + quantity;
	}
	
	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return 0;
	}
}