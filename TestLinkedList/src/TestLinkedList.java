public class TestLinkedList<T> {
	// 定义一个Node类,存放一个对象以及他的next
	private static class Node<U> {
		U item;
		Node<U> next;

		Node() {
			item = null;
			next = null;
		}

		Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}

		boolean isEnd() {
			return item == null && next == null;
		}
	}

	// 初始化一个空的top节点
	private Node<T> top = new Node<T>();

	// push方法,将新节点设为top节点,将之前的top节点作为next
	public void push(T item) {
		top = new Node<T>(item, top);
	}

	// pop方法,返回top节点并将top节点的next设置为top节点
	public T pop() {
		T result = top.item;
		if (!top.isEnd()) {
			top = top.next;
		}
		return result;
	}

	public static void main(String[] args) {
		// 初始化一个String类型的LinkedList
		TestLinkedList<String> tll = new TestLinkedList<String>();
		// 将一个字符串的字符依次入栈,然后再通过pop方法依次出栈
		String str = "hello long time no see";
		for (String s : str.split(" ")) {
			tll.push(s);
		}
		String s;
		// 通过pop依次出栈
		while ((s = tll.pop()) != null) {
			System.out.print(s+ " ");
		}
	}
}
