package xy.Repository;

public class model2 {
	
	private String name;
	
	private model3 model3;

	public model3 getModel3() {
		return model3;
	}

	public void setModel3(model3 model3) {
		this.model3 = model3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "model2 [name=" + name + ", model3=" + model3 + "]";
	}
}
