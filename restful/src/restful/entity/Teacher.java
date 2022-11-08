package restful.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "teacher")  
public class Teacher {
	private String code;  
    private String name;  
    private String title;
    @XmlElement  
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	 @XmlElement  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 @XmlElement  
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
