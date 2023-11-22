import java.util.StringTokenizer;
public class NewToken {
	public static void main(String[] args) {
		int oddeven,oddcount=0,evencount=0;
	StringTokenizer string=new StringTokenizer("2 10 5 8 3 1 55 454 8787");
	int numoftokens=string.countTokens();
	System.out.println("no of tokens is:"+numoftokens);

	while(string.hasMoreElements()) {
		oddeven=Integer.parseInt(string.nextToken());
		if(oddeven%2==0) {
			evencount++;
		}
		else {
			oddcount++;
		}
		
	}
	System.out.println("the no of odd number is:"+oddcount);
	System.out.println("the no of even number is:"+evencount);
	
	}
}