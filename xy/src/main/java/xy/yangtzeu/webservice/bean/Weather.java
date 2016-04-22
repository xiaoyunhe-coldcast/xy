package xy.yangtzeu.webservice.bean;

/**
 * ws的天气实体
 *
 * @author 肖云鹤
 * 2016年4月20日
 */
public class Weather {
	
	/** 地区 xx市  1***/
	private String adress;
	
	/** 更新时间   3**/
	private String date;
	
	/** 基本天气信息 4 **/
	private String base;
	
	/** 具体描述 5**/
	private String description;

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
