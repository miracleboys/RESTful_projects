package restful.api;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import restful.entity.Equivalent;
import restful.entity.Message;

@Path("/sale")
public class TestParamAPI {
	
	Map hobbies = new HashMap<Integer, Equivalent>() {
        {
        	put(0,new Equivalent("可乐",3,999));
        	put(1,new Equivalent("雪碧",3,999));
        	put(2,new Equivalent("橙汁",2.5,999));
        	put(3,new Equivalent("玉龙+C",7,999));
        	put(4,new Equivalent("酱油",14,999));
        	put(5,new Equivalent("水动乐",4,999));
        	put(6,new Equivalent("醋",18,999));
        	put(7,new Equivalent("铅笔",1,0));
        	
           
        }
    };//商品信息
    Map status = new HashMap<Integer,String>(){
    {
    	put(0,"成功售卖");
    	put(-100,"金额不足,全额退款");
    	put(-200,"商品库存不足,全额退款");
    	put(-300,"无此商品售卖,全额退款");
    	}
    };//状态码对应状态信息
    
	@GET
	@Produces("application/json")
	@Path("/act/{goods}/{number}")
	public Message path(@PathParam("goods") int goods,  

            @PathParam("number") int number,  

            @QueryParam("pay") float pay) {
		
			int code;//状态码
			float change=pay;
			Equivalent equivalent = new Equivalent();
			if(goods<8) {  //判断商品是否存在 只有存在时才可以进行商品的计算
			equivalent = (Equivalent) hobbies.get(goods);
			if(equivalent.getPrice()*number <= pay) {
				code = 0;
				change = (float) (pay-equivalent.getPrice()*number);
			}else{
				code=-100;
			}
			if(equivalent.getInventory()-number<=0) {
				code=-200;
				change = pay;
			}
			}else {
				equivalent.setName("未注册商品");
				code =-300;
			}
				
			String resultext = (String) status.get(code);//状态信息
			
			Message message = new Message(equivalent.getName(), number, change, code, resultext);
			//返回信息
		return message;
	}
	
		 
}
