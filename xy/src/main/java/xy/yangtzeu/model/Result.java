package xy.yangtzeu.model;

import java.io.Serializable;

public class Result implements Serializable{

	private static final long serialVersionUID = -8513104762885756967L;
	
	private boolean success;
	
	private String msg;
	
	public Result(boolean success,String msg){
		this.success = success;
		this.msg = msg;
	}
	
	public static Result sucessResult(){
		return successResult("操作成功");
	}

	public static Result successResult(String msg) {
		return new Result(true, msg);
	}
	
	public static Result failureResult(){
		return failureResult("操作失败");
	}
	
	public static Result failureResult(String msg) {
		return new Result(false, msg);
	}
	
	public boolean isSucces(){
		return success;
	}
	
	public  String getMsg(){
		return msg;
	}
	
}
