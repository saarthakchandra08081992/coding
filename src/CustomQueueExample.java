import java.util.Stack;

class Queue{
	Stack<Integer> values = new Stack<Integer>();
	Stack<Integer> temp = new Stack<Integer>();
	
	public void enqueue(int a){
		if(values.size()==0){
			values.push(a);
		}
		else{
			while(!values.isEmpty()){
				int value = values.pop();
				temp.push(value);
			}
			
			values.push(a);
			while(!temp.isEmpty()){
				int value = temp.pop();
				values.push(value);
			}
		}
		System.out.println("Temp is - "+values);	
	}
	
	public int peek(){
		return values.peek();
	}
	
	public int dequeue(){
		return values.pop();
	}
	
	public void print(){
		System.out.println(values);
	}
	
}

public class CustomQueueExample {
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
//		q.print();
		System.out.println(q.dequeue());
	}
}
