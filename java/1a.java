import java.io.*;
class Ass
{

	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter message");
		String s=br.readLine();
		System.out.println(s);
	}
}
