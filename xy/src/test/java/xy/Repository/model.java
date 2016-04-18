package xy.Repository;

public class model {
	
	private String name;
	
	private Integer money;
	
	private model2 mode2;
	
	private model3 mode3;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public model2 getMode2() {
		return mode2;
	}

	public void setMode2(model2 mode2) {
		this.mode2 = mode2;
	}

	public model3 getMode3() {
		return mode3;
	}

	public void setMode3(model3 mode3) {
		this.mode3 = mode3;
	}

	@Override
	public String toString() {
		return "model [name=" + name + ", money=" + money + ", mode2=" + mode2.toString() + ", mode3=" + mode3.toString() + "]";
	}
}
