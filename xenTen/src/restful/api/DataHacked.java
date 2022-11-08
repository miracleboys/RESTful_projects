package restful.api;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import restful.bean.RefreshResult;
import restful.bean.Result;

@Path("/data")
public class DataHacked {
    
	@POST
    @Produces("application/json;charset=UTF-8")    
    @Path("/refresh")
    public Result refresh(@Context HttpServletRequest request,@FormParam("refreshData") String refreshData) {
		Result result = new Result();
//		RefreshResult results = new RefreshResult();
		try {
			// JSONArray
			JSONArray refreshDatas = new JSONArray();
			refreshDatas = JSONArray.fromObject(refreshData);
//			JSONObject refresh = refreshDatas.getJSONObject(0);
			request.getSession().setAttribute("refreshData",refreshDatas);
			result.setCode("0");
			result.setDescription("指令成功接收!");
			result.setNextAction("");
			request.getSession().setAttribute("result", result);
//			results.setOpReturn(result);
//			results.setDataReturn(refreshDatas);
		}catch(Exception Report) {
			result.setCode("-1");
			result.setDescription("指令格式错误，指令接收失败!");
			result.setNextAction("");
//			results.setOpReturn(result);
		}
		
        return result;
    }
}
