import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringAddress{
	private String s;
	public StringAddress(String s){this.s = s;}
	public String toString(){
		return super.toString() + " " + s;
	}
}

public class FillList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<StringAddress> list = new ArrayList<StringAddress>
		(Collections.nCopies(4, new StringAddress("Hello")));
		System.out.println(list);
		Collections.fill(list, new StringAddress("World"));
		System.out.println(list);
	}

}
