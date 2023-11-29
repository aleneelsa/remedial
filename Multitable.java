package java3;
class MultiplicationTable{
	
	synchronized void printMultiplicationtable(int number) {
		
		for(int i=1;i<=10;i++) {
			System.out.println(i+"x"+number+"="+i*number);
		}
	}
}
class MyThread1 extends Thread{
	MultiplicationTable t=new MultiplicationTable();
	MyThread1(MultiplicationTable t){
		this.t=t;			
	}
	public void run() {
		System.out.println(Thread.currentThread().getName());
		t.printMultiplicationtable(5);
		
	}
}
class Mythread2 extends Thread{
	MultiplicationTable t;
	Mythread2(MultiplicationTable t){
		this.t=t;
		
}
	public void run() {
		System.out.println(Thread.currentThread().getName());
		t.printMultiplicationtable(7);
	}
	}
public class Multitable {
	public static void main(String[] args) {
		MultiplicationTable m=new MultiplicationTable();
		MyThread1 t=new MyThread1(m);
		Mythread2 t2=new Mythread2(m);
		t.start();
		t2.start();
		
	}

}
