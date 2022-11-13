package restful.bean;

public class Result {
	private int code;
	private String description;
	private String nextAction;
	
	public Result(int code, String description,String nextAction){
		this.code = code;
		this.description = description;
		this.nextAction = nextAction;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNextAction() {
		return nextAction;
	}

	public void setNextAction(String nextAction) {
		this.nextAction = nextAction;
	}

}