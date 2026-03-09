package lab3_task3;

import java.util.ArrayList;

public class Box<T> {
	private ArrayList<T> list;
		
	public void setItem(T item) {
		list.add(item);
	}

	public T pullItem(Integer index) {
		T tmp = list.get(index);
		list.remove(index);
		return tmp;
	}
}
