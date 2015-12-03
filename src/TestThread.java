
public class TestThread {
//Thread start
	public static void main(String[] args) {
		for(int i=0 ; i <5 ; i++){
			new Thread(new TestRunable()).start();
		}
		System.out.print("wait for thread ");
	}
}
