
public class NumberList {

	int number;
	Node head;
	Node tail;
	
	public void add(int number){

		Node entering = new Node(number);

		if(tail!= null)
			tail.setNext(entering);

		tail = entering;

		if(head == null)
			head = entering;
	}

	public void empty(){

		head = null;

	}
	
	public Node getHead(){
		
		return head;
	}

	public int getNumber(){
		
		return number;
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

	

