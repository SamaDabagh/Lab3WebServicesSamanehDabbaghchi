package webCarREST;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("WebCar")
public class WebCarResource {
	
public static String htmlTable;
public static String plainStr ;

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String displayHTMLCarInfo()
	{
		
		Map<String , Car> carHashMap =  new HashMap<>();
		
		Car car1 =  new Car("K1245" , "Ford" , 35000.00);
		Car car2 =  new Car("M198754" , "Honda" , 40000.00);
		Car car3 =  new Car("M198787" , "Hundai" , 20000.00);
		Car car4 =  new Car("S1288745" , "Nissan" , 35000.00);
		
		carHashMap.put("K1245", car1);
		carHashMap.put("M198754", car2);
		carHashMap.put("M198787", car3);
		carHashMap.put("S1288745", car4);
		
		htmlTable = 
				"<table border = 1 style=\"text-align: center; margin-top: 40px; margin-left: 25%;\"><tr>"
				+"<th style=\"padding: 10px;\"> Car Vin </th>"
				+ "<th style=\"padding: 10px;\">Car Desc</th>"
				+ "<th style=\"padding: 10px;\">Car Price</th>"
				+ "<th style=\"padding: 10px;\">Car Price with Discount</th></tr>";
		
		carHashMap.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue(Comparator.comparing(Car::getPrice)))
		.forEach( car -> {
					htmlTable += "<tr><td style=\"padding: 10px;\">" + car.getKey() + "</td>"
					+ "<td style=\"padding: 10px;\">" + car.getValue().getDesc()+"</td>"
					+ "<td style=\"padding: 10px;\">" +car.getValue().getPrice()+"</td>"
					+ "<td style=\"padding: 10px;\">" +car.getValue().discountPrice()+"</td></tr>";
					});

		return htmlTable;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String  displayTextCarInfo ()
	{
		Map<String , Car> carHashMap =  new HashMap<>();
		
		Car car1 =  new Car("K1245" , "Ford" , 35000.00);
		Car car2 =  new Car("M198754" , "Honda" , 40000.00);
		Car car3 =  new Car("M198787" , "Hundai" , 20000.00);
		Car car4 =  new Car("S1288745" , "Nissan" , 35000.00);
		
		carHashMap.put("K1245", car1);
		carHashMap.put("M198754", car2);
		carHashMap.put("M198787", car3);
		carHashMap.put("S1288745", car4);
		
		plainStr = "";
		carHashMap.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue(Comparator.comparing(Car::getPrice)))
		.forEach( car  -> {
			plainStr += car.getValue().toString();});
		
		return plainStr;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String , Car> displayJSONCarInfo ()
	{
		Map<String , Car> carHashMap =  new HashMap<>();
		
		Car car1 =  new Car("K1245" , "Ford" , 35000.00);
		Car car2 =  new Car("M198754" , "Honda" , 40000.00);
		Car car3 =  new Car("M198787" , "Hundai" , 20000.00);
		Car car4 =  new Car("S1288745" , "Nissan" , 35000.00);
		
		carHashMap.put("K1245", car1);
		carHashMap.put("M198754", car2);
		carHashMap.put("M198787", car3);
		carHashMap.put("S1288745", car4);
		
		Map<String, Car> sortedCarHashMap = carHashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Car::getPrice)))
                .collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);

        return sortedCarHashMap;
		
	}
	
	
	@GET
	@Path("/searchCar/{vin}")
	@Produces(MediaType.APPLICATION_JSON)
	public Car searchJSONCarInfo(@PathParam("vin") String car_vin)
	{
		Car car1 =  new Car("K1245" , "Ford" , 35000.00);
		Car car2 =  new Car("M198754" , "Honda" , 40000.00);
		Car car3 =  new Car("M198787" , "Hundai" , 20000.00);
		Car car4 =  new Car("S1288745" , "Nissan" , 35000.00);
		
		Map<String , Car> carHashMap =  new HashMap<>();
		
		carHashMap.put("K1245", car1);
		carHashMap.put("M198754", car2);
		carHashMap.put("M198787", car3);
		carHashMap.put("S1288745", car4);
		
		Car searchedCar = carHashMap.entrySet().stream().filter(car -> car.getKey().equals(car_vin)).map(Map.Entry::getValue).findFirst().orElse(null);
		return searchedCar;
			
	}
	
}
