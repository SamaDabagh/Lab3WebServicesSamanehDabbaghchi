package webBillingREST;


import java.util.Objects;

public class Billing {
	private int client_ID;
	private String client_LName;
	private String client_FName;
	private String  product_Name;
	private double prd_Price;
	private int prd_Qty;
	public static  double Fed_Tax = 0.075 ;
	public static  double Prv_Tax= 0.06 ;

	
	public Billing()
	{
		client_ID = 0;
		client_LName = "";
		client_FName = "";
		product_Name = "";
		prd_Price = 0.00; 
		prd_Qty = 0;
	}



	
	public Billing(int client_ID, String client_LName, String client_FName, String product_Name, double prd_Price,
			int prd_Qty) 
	{

		this.client_ID = client_ID;
		this.client_LName = client_LName;
		this.client_FName = client_FName;
		this.product_Name = product_Name;
		this.prd_Price = prd_Price;
		this.prd_Qty = prd_Qty;
	}




	public int getClient_ID() {
		return client_ID;
	}




	public void setClient_ID(int client_ID) {
		this.client_ID = client_ID;
	}




	public String getClient_LName() {
		return client_LName;
	}




	public void setClient_LName(String client_LName) {
		this.client_LName = client_LName;
	}




	public String getClient_FName() {
		return client_FName;
	}




	public void setClient_FName(String client_FName) {
		this.client_FName = client_FName;
	}




	public String getProduct_Name() {
		return product_Name;
	}




	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}




	public double getPrd_Price() {
		return prd_Price;
	}




	public void setPrd_Price(double prd_Price) {
		this.prd_Price = prd_Price;
	}




	public int getPrd_Qty() {
		return prd_Qty;
	}




	public void setPrd_Qty(int prd_Qty) {
		this.prd_Qty = prd_Qty;
	}




	public static double getFed_Tax() {
		return Fed_Tax;
	}




	public static void setFed_Tax(double fed_Tax) {
		Fed_Tax = fed_Tax;
	}




	public static double getPrv_Tax() {
		return Prv_Tax;
	}




	public static void setPrv_Tax(double prv_Tax) {
		Prv_Tax = prv_Tax;
	}




	@Override
	public String toString() {
		return "client_ID=" + client_ID + ", client_LName=" + client_LName + ", client_FName=" + client_FName
				+ ", product_Name=" + product_Name + ", prd_Price=" + prd_Price + ", prd_Qty=" + prd_Qty
				;
	}



	@Override
	public int hashCode() {
		return Objects.hash(client_FName, client_ID, client_LName, prd_Price, prd_Qty, product_Name);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Billing other = (Billing) obj;
		return Objects.equals(client_FName, other.client_FName) && Objects.equals(client_ID, other.client_ID)
				&& Objects.equals(client_LName, other.client_LName)
				&& Double.doubleToLongBits(prd_Price) == Double.doubleToLongBits(other.prd_Price)
				&& prd_Qty == other.prd_Qty && Objects.equals(product_Name, other.product_Name);
	}




	public double CalculateBilling()
	{
		double T_Billing = Math.round(((prd_Price* prd_Qty) + (prd_Price*prd_Qty)* Fed_Tax + (prd_Price*prd_Qty)* Prv_Tax)*100.00)/100.00 ;
		return T_Billing;
	}

}
