package restful.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import restful.entity.Schedule;
import restful.entity.Student;

@Path("app/student")  
public class StudentAPI {
	
	@GET  
    @Path("/basicInfo")  
    @Produces("application/json;charset=UTF-8")  
    public Student basicInfo() {  
        Student student = new Student();  
        student.setCode("0140035");  
        student.setName("张三");        
        return student;  
    }  

	
    @POST  
    @Path("/schedule")  
    @Produces("application/xml;charset=UTF-8")  
    public List<Schedule> schedule() {  
        List<Schedule> schedules = new ArrayList<Schedule>();
        
        Schedule schedule = new Schedule();  
        schedule.setCode("00001");  
        schedule.setCaption("线性代数");  
        schedule.setClassNO("A01");  
        schedule.setClassroom("5121");  
        schedule.setTime("1-123");
        schedules.add(schedule);
        
        schedule = new Schedule();  
        schedule.setCode("00002");  
        schedule.setCaption("大学语文");  
        schedule.setClassNO("B03");  
        schedule.setClassroom("1101");  
        schedule.setTime("4-56");  
        schedules.add(schedule);  
        return schedules;  

    }  
}
