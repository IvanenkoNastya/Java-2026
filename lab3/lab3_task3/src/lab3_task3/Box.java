package lab3_task3;

import java.util.ArrayList;

public class Box<T> {
	private ArrayList<T> list;
	
	public Box() {
		list = new ArrayList<>();
	}
	
	public void setItem(T item) {
		list.add(item);
	}

	public T pullItem() {
		if (list.isEmpty()) {
			return null;
		}
		int index = (int)(Math.random() * list.size());
		T tmp = list.get(index);
		list.remove(index);
		return tmp;
	}
	
	public T pullItem(Integer index) {
		if (list.isEmpty()) {
			return null;
		}
		T tmp = list.get(index);
		list.remove(index);
		return tmp;
	}
	
	public void print() {
		for (T item : list) {
			System.out.println(item + ";");			
		}
		return;
	}
}
