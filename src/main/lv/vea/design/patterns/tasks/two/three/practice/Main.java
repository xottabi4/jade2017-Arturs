package lv.vea.design.patterns.tasks.two.three.practice;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shop s = new Shop();
		s.addItem(new Item(2,"bla",9.4));
		
		System.out.println(s.getAllItems(new Customer()).toString());

	}

}
