package part01;

public interface iPro {
	public boolean recordPurchase(String pCode, int purchase);
	public int getPurchases();
	public String toString();
	public String getCode();
	public String getMake();
	public String getModel();
	public double getPrice();
	public int getQuantity();
	public Department getDepartment();
	public void addToQuantity(int qty);
}
