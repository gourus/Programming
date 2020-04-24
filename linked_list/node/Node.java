package linked_list.node;

public class Node {
	
	public int value;
	public Node next;
	
	public Node() {
		this(0);
	}
	
	public Node(int val) {
		this.value = val;
		this.next = null;
	}

}
