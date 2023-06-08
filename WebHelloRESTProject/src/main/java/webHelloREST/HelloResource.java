package webHelloREST;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("HiHi")
public class HelloResource
{
	
@GET
@Produces(MediaType.TEXT_PLAIN)
	public String sayHello()
	{
		return "Hello Every One!";
	}

@GET
@Produces(MediaType.TEXT_HTML)

	public String sayHTMLHello()
	{
		String str = sayHello();
		return "<html><body> <title>Hello Using REST</title><h1>"+str+"</h1></body></html> ";
	}

@GET
@Produces(MediaType.APPLICATION_JSON)
	public University sayJSONHello()
	{
	
		return (new University("Momtreal University", 2023 ,3));
	}


@GET
@Path("/specify/{name}")
@Produces(MediaType.TEXT_HTML)
	public String sayParameterHello(@PathParam("name")  String name)
	{
	String str = sayHello()+" from " + name;
	return "<html><body> <title>Hello Using REST</title><h1>"+str+"</h1></body></html> ";
	}
}
