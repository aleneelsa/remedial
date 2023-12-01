package Newnewpack;

import java.util.Random;
class NumberManager{
	private int generateNumber;
	private boolean NumberGenerated=false;
	public synchronized void generateNumber() {
		generateNumber=new Random().nextInt(99)+2;
		//nextInt(99) means the numbers upto 100 is to be generated.
		//+2 means numbers from 2 is to be generated(greater than one)
		System.out.println("generated random number="+generateNumber);
		NumberGenerated=true;
		notifyAll();//to notify all waiting threads that a number is generated.
	}
	public synchronized void printEvenNumbers() throws InterruptedException {
		while(!NumberGenerated||generateNumber%2!=0) {
			wait();
		}
		for(int i=2;i<=generateNumber;i+=2) {
			System.out.print(i+" ");
		}
		NumberGenerated=false;
	}
   public synchronized void printOddNumbers() throws InterruptedException{
		while(!NumberGenerated||generateNumber%2==0) {
			wait();
		}
		for(int i=1;i<=generateNumber;i+=2){
		System.out.print(i+" ");
		}
		NumberGenerated=false;
	}
}

class NumberGenerater extends Thread{
	NumberManager numbermanager;
	public NumberGenerater(NumberManager numbermanager) {
		this.numbermanager=numbermanager;
	}
	public void run() {
		while(true) {
		numbermanager.generateNumber(); 
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
}

class EvenPrinterThread extends Thread{
	NumberManager numbermanager;
	public EvenPrinterThread(NumberManager numbermanager) {
		this.numbermanager=numbermanager;
	}
	public void run() {
		while(true) {
			try {
				numbermanager.printEvenNumbers();
	            Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class OddPrinterThread extends Thread{
	NumberManager numbermanager;
	public OddPrinterThread(NumberManager numbermanager) {
		this.numbermanager=numbermanager;
	}
	public void run() {
		while(true) {
			try {
				numbermanager.printOddNumbers();
	            Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class OddEvenThread {
public static void main(String [] args) {
	NumberManager numbermanager=new NumberManager();
	NumberGenerater numbergenerater=new NumberGenerater(numbermanager);
	EvenPrinterThread evenprinterthread=new EvenPrinterThread(numbermanager);
	OddPrinterThread oddprinterthread=new OddPrinterThread(numbermanager);
	numbergenerater.start();
	evenprinterthread.start();
	oddprinterthread.start();
}
}
