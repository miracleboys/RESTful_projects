package restful.api;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import restful.bean.Result;

@Path("/data")
public class Data {
    
	@POST
    @Produces("application/json;charset=UTF-8")    
    @Path("/readCommand")
    public Result readCommand(@Context HttpServletRequest request,@FormParam("command") String command) {
		Result result = new Result();

		// JSONArray
		try {
			JSONArray commands = new JSONArray();
			commands = JSONArray.fromObject(command);
//			JSONObject commandJson = commands.getJSONObject(0);
//			System.out.println(commandJson);
//		    System.out.println(commandJson.get("zoneCode"));
			request.getSession().setAttribute("commands",commands);
			// 格式
			
			result.setCode("0");
			result.setDescription("指令成功接收!");
			result.setNextAction("");
		}catch(Exception Report) {
			// 格式
			result.setCode("-1");
			result.setDescription("指令格式错误，指令接收失败!");
			result.setNextAction("");
		}
		
        return result;
    }
}
