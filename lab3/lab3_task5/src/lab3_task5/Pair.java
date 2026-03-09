package lab3_task5;

import java.util.Map;

public class Pair<K, V> {
	private K left;
	private V right;
	
	public Pair(K left, V right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "Pair [left=" + left + ", right=" + right + "]";
	}
	
	public boolean compareTo(Pair<K, V> other) {
		boolean res = false;
		String text = "pairs " + this.toString() + " and " + other.toString();
		if (this.left.equals(other.left) && this.right.equals(other.right)) {
			res = true;
			text += " are equal";
		} else  if (this.left.getClass() == other.left.getClass() 
				|| this.right.getClass() != other.right.getClass()) { // this will never occur
			text += " are same type, but different values";
		} else {
			text += " are different";
		}
		System.out.println(text);
		return res;
	}	
}
