package webBillingREST;

import java.util.*;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.QueryParam;
import com.google.gson.Gson;




@Path("WebBilling")
public class WebBillingResource {
	List <Billing> BillingRecords= new ArrayList<Billing>(3);
	public void addName()
	{
		List <Billing> BillingRecords= new ArrayList<Billing>(3);
		BillingRecords.add(new Billing ( 101,"Johnston", "Jane" , "Chair", 99.99 , 2 ));
		BillingRecords.add(new Billing ( 105,"Fikhali", "Samuel" , "Table", 139.99 , 1 ));
		BillingRecords.add(new Billing ( 110,"Samson", "Amina" , "KeyUSB", 14.99 , 2 ));
		
	}
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String displayHTMLBillingInfo()
	{
		addName();
		
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
		addName();

		
		double totalBilling = 0.00;
		String plainStr = "";
		for(Billing BillingRecord : BillingRecords)
		{
			totalBilling += BillingRecord.CalculateBilling();
			plainStr +="\nComponent at index "+BillingRecords.indexOf(BillingRecord)+" :" +BillingRecord.toString();
		}
		
		return plainStr +"\nThe Total of Course Fee is: "+totalBilling+" $";
	}
	
	@GET
	@Path("/searchBilling/{client_ID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Billing searchJSONBillingInfo(@PathParam("client_ID") int client_ID)
	{
		addName();

		for(Billing billingRecord : BillingRecords)
		{
			if (billingRecord.getClient_ID() == client_ID)
				return billingRecord;
		}
		
		return null;
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/searchBilling1")
    public Billing earchAsQPBillingInfo(@QueryParam("client_ID") int client_ID) {
		
		addName();

		for(Billing billingRecord : BillingRecords)
		{
			if (billingRecord.getClient_ID() == client_ID)
				return billingRecord;
		}
		
		return null;
    }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addNewBilling")
	public String addNewBilling(
	        @FormParam("client_ID") int client_Id,
	        @FormParam("client_LName") String client_LName,
	        @FormParam("client_FName") String client_FName,
	        @FormParam("product_Name") String product_Name,
	        @FormParam("prd_Price") double prd_Price,
	        @FormParam("prd_Qty") int prd_Qty) {

	    Billing newBilling = new Billing(client_Id, client_LName, client_FName, product_Name, prd_Price, prd_Qty);

		addName();

		BillingRecords.add(newBilling);

		Gson gson = new Gson();
		String jsonOutput = "";
		for(Billing billingRecord : BillingRecords)
		{
			  jsonOutput += gson.toJson(billingRecord);
			
		}
	  

	    return jsonOutput;
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Path("/addNewBilling")
	public String addNewBillingInfo(
	        @FormParam("client_ID") int client_Id,
	        @FormParam("client_LName") String client_LName,
	        @FormParam("client_FName") String client_FName,
	        @FormParam("product_Name") String product_Name,
	        @FormParam("prd_Price") double prd_Price,
	        @FormParam("prd_Qty") int prd_Qty) {

	    Billing newBilling = new Billing(client_Id, client_LName, client_FName, product_Name, prd_Price, prd_Qty);

		addName();

		BillingRecords.add(newBilling);

	    StringBuilder htmlOutput = new StringBuilder();
	    htmlOutput.append("<html>");
	    htmlOutput.append("<body>");
	    htmlOutput.append("<h1>New Billing Information Added</h1>");
	    htmlOutput.append("<ul>");

	    // Iterate through BillingRecords and add each billing record to the HTML output
	    for (Billing billingRecord : BillingRecords) {
	        htmlOutput.append("<li>");
	        htmlOutput.append("Client ID: ").append(billingRecord.getClient_ID()).append("<br/>");
	        htmlOutput.append("Last Name: ").append(billingRecord.getClient_LName()).append("<br/>");
	        htmlOutput.append("First Name: ").append(billingRecord.getClient_FName()).append("<br/>");
	        htmlOutput.append("Product Name: ").append(billingRecord.getProduct_Name()).append("<br/>");
	        htmlOutput.append("Product Price: ").append(billingRecord.getPrd_Price()).append("<br/>");
	        htmlOutput.append("Product Quantity: ").append(billingRecord.getPrd_Qty()).append("<br/>");
	        htmlOutput.append("</li>");
	    }

	    htmlOutput.append("</ul>");
	    htmlOutput.append("</body>");
	    htmlOutput.append("</html>");

	    // Return the HTML output as a String
	    return htmlOutput.toString();
	}
	
}
