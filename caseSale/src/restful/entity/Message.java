package restful.entity;

public class Message {
	private String name;
	private int amount;
	private float change;
	private int resultCode;
	private String resultText;
	
	public Message(String name,int amount,float change,int resultCode,String resultText) {
		this.name=name;
		this.amount=amount;
		this.change=change;
		this.resultCode=resultCode;
		this.resultText=resultText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getChange() {
		return change;
	}

	public void setChange(float change) {
		this.change = change;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultText() {
		return resultText;
	}

	public void setResultText(String resultText) {
		this.resultText = resultText;
	}
	
}
