public class TestBean {
	private String var1;
	private String var2;

	public TestBean(String var1, String var2) {
		this.var1 = var1;
		this.var2 = var2;
	}

	public String getVar1() {
		return var1;
	}

	public void setVar1(String var1) {
		this.var1 = var1;
	}

	public String getVar2() {
		return var2;
	}

	public void setVar2(String var2) {
		this.var2 = var2;
	}

	public String toString() {
		return getVar1() + getVar2();
	}
}
