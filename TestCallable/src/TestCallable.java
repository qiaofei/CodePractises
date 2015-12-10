import java.util.concurrent.Callable;

public class TestCallable implements Callable<String> {
	private int id;

	public TestCallable(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "id = " + this.id;
	}

}
