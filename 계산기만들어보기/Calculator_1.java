package 계산기만들어보기;

public class Calculator_1 {
	int x;
	int y;
	
	public Calculator_1(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void add() {
		double result = x + y;
		System.out.println(result);
	}
	
	public void min() {
		double result = x - y;
		System.out.println(result);
	}
	
	public void mul() {
		double result = x * y;
		System.out.println(result);
	}
	
	public void div() {
		double result = x / y;
		System.out.println(result);
	}


	
}
