package webCarREST;



import java.util.Objects;

public class Car {

			private String vin;
			private String desc;
			private double price;

//			public Car(String string, String string2, double d)
//			{
//				this.vin = "";
//				this.desc = "";
//				this.price = 0.0;
//
//			}
//			
			

			public Car(String vin, String desc, double price) {
				this.vin = vin;
				this.desc = desc;
				this.price = price;
			}



			public String getVin() {
				return vin;
			}

			public void setVin(String vin) {
				this.vin = vin;
			}

			public String getDesc() {
				return desc;
			}

			public void setDesc(String desc) {
				this.desc = desc;
			}

			public double getPrice() {
				return price;
			}

			public void setPrice(double price) {
				this.price = price;
			}



			@Override
			public String toString() {
				return " Car_Vin: " + vin + ", Car_Desc: " + desc + ", Car_Price: " + price + ",Car_PriceWithDiscount: " +this.discountPrice()+" \n";
			}



			@Override
			public int hashCode() {
				return Objects.hash(desc, price, vin);
			}



			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Car other = (Car) obj;
				return Objects.equals(desc, other.desc)
						&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
						&& Objects.equals(vin, other.vin);
			}

			public double discountPrice()
			{
				
				return getPrice() * 0.9;
			}

}