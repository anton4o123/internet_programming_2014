public class Fundamentals {
	private int b;
	
	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public static void main(String[] args) {
		int a=0;
		int b=a+10;
		Fundamentals f=new Fundamentals();
		Fundamentals f2=new Fundamentals();
		
		if(a<b) {
			System.out.println("hello");
		}
		
		for(int i=a;i<b;a+=++i);
		
		if(a>b) {
			System.out.println("goodbye");
		}
		
		f.setB(5);
		f2.setB(4);
		System.out.println(f.equals(f2));
		System.out.println(f==f2);
	}
}
