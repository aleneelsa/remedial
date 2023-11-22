import java.util.StringTokenizer;
public class StringTok {
	public static void main(String[] args) {
	StringTokenizer string=new StringTokenizer("hello, how, are, you, .",",",false);
	int numoftokens=string.countTokens();
	System.out.println("no of tokens is:"+numoftokens);

	while(string.hasMoreElements()) {
		System.out.print("next token :");
	System.out.println(string.nextToken());
	}
	}
}