package tese1;

import java.util.Random;

public class App {
	MyDList list1=new MyDList();
	MyDList list2=new MyDList();
	
	public App() {
		for(int i=0;i<10;i++) {
			int value = (int)Math.random()*100;
			list1.push_back(value);
		}
		for(int i=0;i<10;i++) {
			int value = (int)Math.random()*100;
			list2.push_back(value);
		}
	}
	void Print_List() {
		MyDList.DNode node = list1.getHead();
		while(node != null) {
			System.out.print(node.data+" "); 
		}
		node = list2.getHead();
		while(node != null) {
			System.out.print(node.data+" "); 
		}
	}
}
