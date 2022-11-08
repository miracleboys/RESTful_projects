package restful.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import restful.entity.Schedule;
import restful.entity.Teacher;

@Path("app/teacher")  
public class TeacherAPI {
	
	 @GET  
	 @Path("/basicInfo")
	 @Produces("application/xml;charset=UTF-8")  
	 public Teacher basicInfo() {
		 Teacher teacher = new Teacher();  
		 teacher.setCode("000001");  
		 teacher.setName("陈老师");  
		 teacher.setTitle("讲师");  
		 return teacher;
		 }  

	 	@POST  
	    @Path("/schedule")  
	    @Produces("application/json;charset=UTF-8")  
	    public List<Schedule> schedule() {  
	        List<Schedule> schedules = new ArrayList<Schedule>();  
	        Schedule schedule = new Schedule();  
	        schedule.setCode("00002");  
	        schedule.setCaption("大学语文");  
	        schedule.setClassNO("B03");  
	        schedule.setClassroom("1101");  
	        schedule.setTime("4-56");  
	        schedules.add(schedule);  
	        return schedules;  

	    }  
}
