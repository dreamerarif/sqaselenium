package SQA;

public class ExceptionExample {
	int c;
	public void divide(int A, int B)
	{
		int a = A;
		int b = B;
		try {
			c= a/b;
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("Can't divide by zero");
		}
		System.out.println(c);
		int d = a+b;
		System.out.println(d);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExceptionExample except = new ExceptionExample();
		except.divide(10,20);
	}

}
