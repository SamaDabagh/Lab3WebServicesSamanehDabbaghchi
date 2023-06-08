package webBillingREST;

import java.util.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("WebBilling")
public class WebBillingResource {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String displayHTMLBillingInfo()
	{
		List <Billing> BillingRecords= new ArrayList<Billing>(3);
		BillingRecords.add(new Billing ( 101,"Johnston", "Jane" , "Chair", 99.99 , 2 ));
		BillingRecords.add(new Billing ( 105,"Fikhali", "Samuel" , "Table", 139.99 , 1 ));
		BillingRecords.add(new Billing ( 110,"Samson", "Amina" , "KeyUSB", 14.99 , 2 ));
		
		double totalBilling = 0.00;

		String htmlTable ="<table border = 1 style=\"text-align: center; margin-top: 40px; margin-left: 20%;\">"
				+ "<tr><th style=\"padding: 10px;\"> Client_ID </th>"
				+"<th style=\"padding: 10px;\"> Client_FName </th>"
				+ "<th style=\"padding: 10px;\">Client_LName</th>"
				+ "<th style=\"padding: 10px;\">Product_Name</th>"
				+ "<th style=\"padding: 10px;\">Prd_Price</th>"
				+ "<th style=\"padding: 10px;\">Prd_Qty</th>"
				+ "<th style=\"padding: 10px;\">Total Billing</th></tr>";
				
				for(Billing BillingRecord : BillingRecords) 
				{
					htmlTable+=
						"<tr><td style=\"padding: 10px;\">" +BillingRecord.getClient_ID()+ "</td>"
						+"<td style=\"padding: 10px;\">" +BillingRecord.getClient_LName()+ "</td>"
						+ "<td style=\"padding: 10px;\">" +BillingRecord.getClient_FName()+"</td>"
						+ "<td style=\"padding: 10px;\">" +BillingRecord.getProduct_Name()+"</td>"
						+ "<td style=\"padding: 10px;\">" +BillingRecord.getPrd_Price()+"</td>"
						+ "<td style=\"padding: 10px;\">" +BillingRecord.getPrd_Qty()+"</td>"
						+ "<td style=\"padding: 10px;\">" +BillingRecord.CalculateBilling()+"</td></tr>";
					
					totalBilling += BillingRecord.CalculateBilling();

				}
				
				htmlTable += "</table></br><h2 style=\"text-align: center; margin-top: 40px; \">The Total of Course Fee is: "+totalBilling+" $</h2>";
				
				return htmlTable;
						
						
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String displayTextBillingInfo()
	{
		List <Billing> BillingRecords= new ArrayList<Billing>(3);
		BillingRecords.add(new Billing ( 101,"Johnston", "Jane" , "Chair", 99.99 , 2 ));
		BillingRecords.add(new Billing ( 105,"Fikhali", "Samuel" , "Table", 139.99 , 1 ));
		BillingRecords.add(new Billing ( 110,"Samson", "Amina" , "KeyUSB", 14.99 , 2 ));
		
		
		double totalBilling = 0.00;
		String plainStr = "";
		for(Billing BillingRecord : BillingRecords)
		{
			totalBilling += BillingRecord.CalculateBilling();
			plainStr +="\nComponent at index "+BillingRecords.indexOf(BillingRecord)+" :" +BillingRecords.get(0).toString();
		}
		
		return plainStr +"\nThe Total of Course Fee is: "+totalBilling+" $";
	}
	
	@GET
	@Path("/searchBilling/{client_ID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Billing searchJSONBillingInfo(@PathParam("client_ID") int client_ID)
	{
		List <Billing> BillingRecords= new ArrayList<Billing>(3);
		BillingRecords.add(new Billing ( 101,"Johnston", "Jane" , "Chair", 99.99 , 2 ));
		BillingRecords.add(new Billing ( 105,"Fikhali", "Samuel" , "Table", 139.99 , 1 ));
		BillingRecords.add(new Billing ( 110,"Samson", "Amina" , "KeyUSB", 14.99 , 2 ));
		
		for(Billing billingRecord : BillingRecords)
		{
			if (billingRecord.getClient_ID() == client_ID)
				return billingRecord;
		}
		
		return null;
	}

	
}
