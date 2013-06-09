
public class Possibilities {

	Node head;
	Node tail;

	public Possibilities(){

	}

	public void add(int number){

		Node entering = new Node(number);

		if(tail!= null)
			tail.setNext(entering);

		tail = entering;

		if(head == null)
			head = entering;
	}

	public int deque(){

		int value = head.getNumber();
		head = head.getNext();

		return value;
	}

	public Node getHead(){

		return head;
	}

	public void empty(){

		head = null;

	}

	public String toString()
	{
		String s = "";

		Node ptr = head;
		while (ptr != null)
		{
			s += ptr.getNumber();
			ptr = ptr.getNext();
		}

		return s;
	}

	public static class Node{

		int number;
		Node next;

		public Node(int number){

			number = this.number;
		}

		public void setNext(Node next){

			next = this.next;
		}

		public Node getNext(){

			return next;
		}

		public int getNumber(){

			return number;
		}
	}
}



