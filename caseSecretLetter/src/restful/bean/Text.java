package restful.bean;

import javax.ws.rs.FormParam;

public class Text {
	@FormParam("cipher1")
	private String cipher1;
	
	@FormParam("code")
	private String code;
	
	@FormParam("key")
	private String key;
	
	@FormParam("newKey")
	private String newKey;
	
	@FormParam("cipherText")
	private String cipherText;
	
	@FormParam("cipher2")
	private String cipher2;

	public String getCipher1() {
		return cipher1;
	}

	public void setCipher1(String cipher1) {
		this.cipher1 = cipher1;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getNewKey() {
		return newKey;
	}

	public void setNewKey(String newKey) {
		this.newKey = newKey;
	}

	public String getCipherText() {
		return cipherText;
	}

	public void setCipherText(String cipherText) {
		this.cipherText = cipherText;
	}

	public String getCipher2() {
		return cipher2;
	}

	public void setCipher2(String cipher2) {
		this.cipher2 = cipher2;
	}

	



}
