package restful.bean;

import net.sf.json.JSONArray;

public class RefreshResult {
	private Result opReturn;
	private JSONArray dataReturn;

	public Result getOpReturn() {
		return opReturn;
	}
	public void setOpReturn(Result opReturn) {
		this.opReturn = opReturn;
	}
	public JSONArray getDataReturn() {
		return dataReturn;
	}
	public void setDataReturn(JSONArray dataReturn) {
		this.dataReturn = dataReturn;
	}
	
}
