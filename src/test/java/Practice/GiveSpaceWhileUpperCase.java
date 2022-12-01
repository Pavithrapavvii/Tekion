package Practice;

public class GiveSpaceWhileUpperCase
{	
	public static void main(String[] args) 
	{
		String s="IAmASoftwareEngineer";

		//System.out.print(s.charAt(0));
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				System.out.print(" ");
			}
			System.out.print(s.charAt(i));
		} 
	}
}


