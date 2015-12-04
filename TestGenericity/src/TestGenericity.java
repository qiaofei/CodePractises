public class TestGenericity<T> {

	/**
	 * @param args
	 */
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public TestGenericity(T t) {
		this.t = t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGenericity<TestBean> tg = new TestGenericity<TestBean>(
				new TestBean("tb", "2"));
		TestBean tb2 = tg.getT();
		System.out.println(tb2.toString());
	}

}
