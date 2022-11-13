package restful.api;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import restful.annotation.BoxPower;
import restful.bean.Result;

/*
 *  请同学们配合拦截器代码做适当代码补充。
 */

@Path("/box")
public class GameAPI {
	
	@Context HttpServletRequest request;
	
	@POST
	@Path("/ini")
	@Produces("application/json;charset=UTF-8")
	public Result ini(@FormParam("username") String username) {
		HashMap<String,String> powerList = new HashMap<String,String>();
		powerList.put("box1","");
		request.getSession().setAttribute("powerList", powerList);
		request.getSession().setAttribute("username", username);		
	    return new Result(0,username+",你胆敢来挑战我？那就试试吧！","");
	}
	
	@POST
	@Path("/question1")
	@Produces("application/json;charset=UTF-8")
	@BoxPower("box1")
	public Result question1() {
//		if(request.getSession().getAttribute("username") == null ) {
//			return (Result) request.getSession().getAttribute("result");
//		}
		Result result = new Result(0, null, null);
		result.setDescription("爸爸的爸爸叫什么");
		result.setNextAction("/box/answer1");
	    return result;
	}
	
	@SuppressWarnings("unchecked")
	@POST
	@Path("/answer1")
	@Produces("application/json;charset=UTF-8")
	@BoxPower("box1")
	public Result answer1(@FormParam("answer") String answer) {
		if(answer.equals("爷爷") ) {
			HashMap<String, String> list = (HashMap<String, String>) request.getSession().getAttribute("powerList");
			list.put("box2", "");
			request.getSession().setAttribute("powerList", list);
			return new Result(0, "恭喜你，聪明的智商占领高地了", "null");
		}else {
			return new Result(-10, "你真是个衰仔", "null");
		}
	    
	}
	
	@POST
	@Path("/question2")
	@Produces("application/json;charset=UTF-8")
	@BoxPower("box2")
	public Result question2() {
//		if(request.getSession().getAttribute("username") == null ) {
//			return (Result) request.getSession().getAttribute("result");
//		}
		HashMap<String, String> list = (HashMap<String, String>) request.getSession().getAttribute("powerList");
		Result result = new Result(0, null, null);
		result.setDescription("大锤八十，小锤____");
		result.setNextAction("/box/answer2");
	    return result;
		
	
	}
	
	@SuppressWarnings("unchecked")
	@POST
	@Path("/answer2")
	@Produces("application/json;charset=UTF-8")
	@BoxPower("box2")
	public Result answer2(@FormParam("answer") String answer) {
		
		if(answer.equals("四十") ) {
			HashMap<String, String> list = (HashMap<String, String>) request.getSession().getAttribute("powerList");
			list.put("box3", "");
			request.getSession().setAttribute("powerList", list);
			return new Result(0, "恭喜你，聪明的智商占领高地了", "null");
		}else {
			return new Result(-10, "你真是个衰仔", "null");
		}
	    
	}
	
	@POST
	@Path("/question3")
	@Produces("application/json;charset=UTF-8")
	@BoxPower("box3")
	public Result question3() {
//		if(request.getSession().getAttribute("username") == null ) {
//			return (Result) request.getSession().getAttribute("result");
//		}
		HashMap<String, String> list = (HashMap<String, String>) request.getSession().getAttribute("powerList");
	
		Result result = new Result(0, null, null);
		result.setDescription("双脚离地了，病毒就关闭了，______");
		result.setNextAction("/box/answer3");
	    return result;
	
	
	}
	
	@SuppressWarnings("unchecked")
	@POST
	@Path("/answer3")
	@Produces("application/json;charset=UTF-8")
	@BoxPower("box3")
	public Result answer3(@FormParam("answer") String answer) {
		
		if(answer.equals("聪明的智商占领高地了") ) {
			HashMap<String, String> list = (HashMap<String, String>) request.getSession().getAttribute("powerList");
			list.put("box4", "");
			request.getSession().setAttribute("powerList", list);
			return new Result(0, "恭喜你，聪明的智商占领高地了", "null");
		}else {
			return new Result(-10, "你真是个衰仔", "null");
		}
	}
	
	@POST
	@Path("/question4")
	@Produces("application/json;charset=UTF-8")
	@BoxPower("box4")
	public Result question4() {
//		if(request.getSession().getAttribute("username") == null ) {
//			return (Result) request.getSession().getAttribute("result");
//		}
		HashMap<String, String> list = (HashMap<String, String>) request.getSession().getAttribute("powerList");
		Result result = new Result(0, null, null);
		result.setDescription("齐德龙,齐东强,_______");
		result.setNextAction("/box/answer4");
	    return result;
	
	
	}
	
	@SuppressWarnings("unchecked")
	@POST
	@Path("/answer4")
	@Produces("application/json;charset=UTF-8")
	@BoxPower("box4")
	public Result answer4(@FormParam("answer") String answer) {
		
		if(answer.equals("齐得隆咚呛") ) {
			HashMap<String, String> list = (HashMap<String, String>) request.getSession().getAttribute("powerList");
			list.put("box5", "");
			request.getSession().setAttribute("powerList", list);
			return new Result(0, "恭喜你，聪明的智商占领高地了", "null");
		}else {
			return new Result(-10, "你真是个衰仔", "null");
		}
	}
	
	@POST
	@Path("/question5")
	@Produces("application/json;charset=UTF-8")
	@BoxPower("box5")
	public Result question5() {
//		if(request.getSession().getAttribute("username") == null ) {
//			return (Result) request.getSession().getAttribute("result");
//		}
		HashMap<String, String> list = (HashMap<String, String>) request.getSession().getAttribute("powerList");
		Result result = new Result(0, null, null);
		result.setDescription("《天工开物》的作者");
		result.setNextAction("/box/answer5");
	    return result;
		
		
	
	}
	
	@SuppressWarnings("unchecked")
	@POST
	@Path("/answer5")
	@Produces("application/json;charset=UTF-8")
	@BoxPower("box5")
	public Result answer5(@FormParam("answer") String answer) {
		
		if(answer.equals("宋应星") ) {
//			HashMap<String, String> list = (HashMap<String, String>) request.getSession().getAttribute("powerList");
//			list.put("box5", "回答正确");
//			request.getSession().setAttribute("powerList", list);
			return new Result(10, "恭喜你成功出院!", "/box/finish");
		}else {
			return new Result(-10, "你真是个衰仔", "null");
		}
	}
	
	@POST
	@Path("/finish")	
	@Produces("application/json;charset=UTF-8")
	@BoxPower("finish")
	public Result finish() {
		HashMap<String, String> powerList = (HashMap<String, String>) request.getSession().getAttribute("powerList");
		String username = (String) request.getSession().getAttribute("username");
		username = null;
		powerList.clear();
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("powerList", powerList);
		return new Result(0, "任务完成", "");
	   
	}

}
