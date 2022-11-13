package restful.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

import restful.annotation.BoxPower;
import restful.bean.Result;


@SuppressWarnings("deprecation")
public class Interceptor4PreProcess implements PreProcessInterceptor {
	
	@Context HttpServletRequest request;

	@Override
	public ServerResponse preProcess(HttpRequest httpRequest, ResourceMethodInvoker resourceMethodInvoker) {
		 Method method = resourceMethodInvoker.getMethod();
		 Annotation[] annotations = method.getDeclaredAnnotations();
		 
		if(method.isAnnotationPresent(BoxPower.class)) {
			 Annotation annotation = method.getAnnotation(BoxPower.class); 
			 String url = request.getRequestURI();                                 //获取访问路径：/casePowerGame/box/***
			 String path = url.split("/")[3];                                      //通过分割将最后一个路径名取出来
			 String boxPowerValue = ((BoxPower)annotation).value();
			 if(request.getSession().getAttribute("username") == null) {
				 Result result = new Result(-20, "无名之辈也敢来挑战", "/box/ini");
				 return new ServerResponse(result, 200, new Headers<Object>());

			 }else {
				 HashMap<String,String> powerList = (HashMap<String, String>)request.getSession().getAttribute("powerList");  
				if(path.substring(0, path.length()-1).equals("question") && !powerList.containsKey(((BoxPower) annotation).value())) {    //如果访问路径是问题并且上一个箱子答案为空就进行拦截
					return new ServerResponse(new Result(-10, "你想投机取巧，还是乖乖地按顺序回答我的问题！", ""), 200, new Headers<Object>()); 
				}
			}
			 System.out.println(boxPowerValue);
		}
		return null;
	}

}
