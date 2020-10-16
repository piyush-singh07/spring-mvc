package pack1;

public class Parent {

	public static void m1() {
		System.out.println("Parent");
	}

}

class Child extends Parent {
	public static void m1() {
		System.out.println("Child");
	}

}

