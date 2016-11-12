import java.util.Comparator;

class Humans {
	protected int height;
	protected int weight;

	Humans(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}
	
	protected int getHeight(){
		return this.height;
	}
}

public class PriorityQueue {

	public static void main(String[] args) {
		java.util.PriorityQueue<Humans> humansQueue = new java.util.PriorityQueue<Humans>(new Comparator<Humans>() {

			@Override
			public int compare(Humans o1, Humans o2) {
				return o1.height - o2.height;
			}
		
		});
		Humans me = new Humans(5,60);
		humansQueue.add(me);
		humansQueue.add(new Humans(6,60));
		humansQueue.add(new Humans(4,60));
		humansQueue.add(new Humans(1,60));
		humansQueue.add(new Humans(10,60));
		
		System.out.println("Height is  - "+humansQueue.poll().getHeight());
		System.out.println("Contains is  - "+humansQueue.contains(me));
		System.out.println("Contains is  - "+humansQueue.contains(new Humans(5,61)));
	}
}
