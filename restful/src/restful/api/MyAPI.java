package restful.api;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/a")
public class MyAPI {
	@GET
	@Path("/b")
	@Produces("text/html; charset=gb2312")  
	public String getMyName() {
		return "<font color='red'>你好</font>";  
	}
	
	
}

