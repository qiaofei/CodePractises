public class TestLinkedList<T> {
	// ����һ��Node��,���һ�������Լ�����next
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

	// ��ʼ��һ���յ�top�ڵ�
	private Node<T> top = new Node<T>();

	// push����,���½ڵ���Ϊtop�ڵ�,��֮ǰ��top�ڵ���Ϊnext
	public void push(T item) {
		top = new Node<T>(item, top);
	}

	// pop����,����top�ڵ㲢��top�ڵ��next����Ϊtop�ڵ�
	public T pop() {
		T result = top.item;
		if (!top.isEnd()) {
			top = top.next;
		}
		return result;
	}

	public static void main(String[] args) {
		// ��ʼ��һ��String���͵�LinkedList
		TestLinkedList<String> tll = new TestLinkedList<String>();
		// ��һ���ַ������ַ�������ջ,Ȼ����ͨ��pop�������γ�ջ
		String str = "hello long time no see";
		for (String s : str.split(" ")) {
			tll.push(s);
		}
		String s;
		// ͨ��pop���γ�ջ
		while ((s = tll.pop()) != null) {
			System.out.print(s+ " ");
		}
	}
}
