
public class TestRunable implements Runnable{
	//����һ����������static int ������ʾ��ǰ����id
	private static int taskCount = 0;
	private final int id = taskCount++;
	private int countDown = 10;
	public void run() {
		while(countDown-- > 0 ){
			System.out.print(status());
			Thread.yield();
		}
	}
	public String status(){
		return id+"(" +
		(countDown>0? countDown: "over")+")  ";
	}
	
}
