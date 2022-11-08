package restful.filter;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import restful.bean.Result;

public class DataFilter implements ContainerRequestFilter, ContainerResponseFilter {

	private @Context HttpServletRequest request;

	private URI invalidatedURI = URI.create("/invalidated");
    // 响应过滤器
	@Override
	public void filter(ContainerRequestContext containerRequestContext,
			ContainerResponseContext containerResponseContext) throws IOException {
		System.out.println("---------------- 响应过滤器开始 -------------------");
		String url = containerRequestContext.getUriInfo().getPath();
		
		if (url != null && url.equals("/data/refresh")) {
			
			JSONObject result = new JSONObject();
			Object re = new Object();
			JSONObject opReturn = new JSONObject();
			JSONArray dataReturn = new JSONArray();
			JSONArray oldCommands = new JSONArray();
			JSONArray  refreshData = new JSONArray();
			JSONArray newCommands = new JSONArray();
			
			re = request.getSession().getAttribute("result");
			opReturn = JSONObject.fromObject(re);
			oldCommands = (JSONArray) request.getSession().getAttribute("commands");
			refreshData= (JSONArray) request.getSession().getAttribute("refreshData");
			
			
			
			int len = 0;
			int len2 = 0;
			
			try {
				len = oldCommands.size();
				len2 = refreshData.size();
				if(len!=0 && len2 != 0 && len < len2 ) {
					for(int i=0;i<len;i++) {
						newCommands.add(refreshData.get(i));
					}
				}else if(len!=0 && len2 != 0 && len > len2) {
					for(int i=0;i<len2;i++) {
						newCommands.add(refreshData.get(i));
					}
					for(int i = len2;i<len;i++) {
						newCommands.add(oldCommands.get(i));
					}
				}else if(len!=0 && len2 != 0 ){
					newCommands = refreshData;
				}
				
				request.getSession().setAttribute("commands", newCommands);
				
				result.put("opReturn", opReturn);
				result.put("dataReturn",newCommands);
				
				containerResponseContext.setEntity(result);
			}catch( Exception Report){
				
			}
			System.out.println(len);
			System.out.println(len2);


		
			
			

		}
		

//		containerResponseContext.setEntity(entityString);
		System.out.println("---------------- 响应过滤器结束 -------------------");
	}
	
    // 请求过滤器 
	@Override
	public void filter(ContainerRequestContext containerRequestContext) throws IOException {
		System.out.println("---------------- 请求过滤器开始 -------------------");
		String url = containerRequestContext.getUriInfo().getPath();

		System.out.println(url);
		
		// 校验
		if (url.equals("/data/refresh")) {
			if(!authoration(containerRequestContext)) {
				containerRequestContext.abortWith(
						Response.temporaryRedirect(invalidatedURI).build()
						);
			}
		}
		
		System.out.println("---------------- 请求过滤器结束 -------------------");
	}

	private boolean authoration(ContainerRequestContext containerRequestContext) {
		// 得到地址和参数
		String url = containerRequestContext.getUriInfo().getPath();
		String sCode = request.getParameter("sCode");
		String xCode = request.getParameter("xCode");
		String rCode = request.getParameter("rCode");
		
		int s = Integer.parseInt(sCode);
		int x = Integer.parseInt(xCode);
		int r = Integer.parseInt(rCode);
		
		if((s%x) == r) {
			return true;
		}else {
			return false;
		}

	}

}
