package classexamples;
import java.io.IOException;
//
import java.util.Scanner;
//
public class CountNumberofChars
{
//public static int countChar(String s, char c)
//{
//if(word.length() == 0){return 0;} //When word length is 0 then terminate
//  
//if ((word.substring(0,1).equals(ch))) //check every char for a match with the word
//{
////add 1 to the result for the rest of the string
////call recursively till all chars are searched within the word
//return 1 + countRepeatingChars(word.substring(1), ch);
//}
////If no match found then call again with next character
//return countRepeatingChars(word.substring(1), ch);
//}
//
//public static void main(String[] args) {
//Scanner in = new Scanner(System.in);
//System.out.print("Please enter a word: ");
//String word = in.nextLine();
//System.out.print("Please enter a character: ");
//String ch = in.next();
//System.out.println("\nNumber of occurrences of given character: "+countRepeatingChars(word, ch));
//}
//}


//public static int count (String s, char c)
//{
//    int charTotal = 0; //= 0;
//
//    for (int x = 0 ; x < s.length () ; x++)
//    {
//        if (s.charAt (x) == c)
//        {
//            charTotal++;
//            s = s.substring (0, x) + s.substring (x + 1);
//            return charTotal + count (s, c);
//        }
//        else
//            return charTotal;
//    }
//    return charTotal;
//}
	
	
//	public static int count (String line, char c)
//	{
//	    int len = line.length();
//	    if ((len == 0) || (c == '\0'))   // obvious case for empty string or nil char.
//	       return 0;                     // Your recursion always ends here
//
//	    String rest = line.substring(1);
//	    if (line.charAt(0) == c)     
//	    {
//	       return count(rest, c) + 1;   // recurse on substring
//	    }
//	    else
//	    {
//	       return count(rest, c);   // recurse on substring
//	    }
//	}
	
	
	
//	import java.util.Scanner;
//	public class Palindromes
//	{

//	    public static boolean isPal(String s)
//	    {
//	        if(s.length() == 0 || s.length() == 1)
//	            // if length =0 OR 1 then it is
//	            return true; 
//	        if(s.charAt(0) == s.charAt(s.length()-1))
//	            // check for first and last char of String:
//	            // if they are same then do the same thing for a substring
//	            // with first and last char removed. and carry on this
//	            // until you string completes or condition fails
//	            return isPal(s.substring(1, s.length()-1));
//
//	        // if its not the case than string is not.
//	        return false;
//	    }
	
//	public static boolean isPalindrome(String s) {
//	    int len = s.length();
//	    if (len <= 1) {
//	        return true;
//	    }
//	    return (s.charAt(0) == s.charAt(len - 1)) &&
//	           isPalindrome(s.substring(1, len - 1));
//	}
//
//	    public static void main(String[]args)
//	    {
//	        Scanner sc = new Scanner(System.in);
//	        System.out.println("type a word to check if its a palindrome or not");
//	        String x = sc.nextLine();
//	        if(isPalindrome(x))
//	            System.out.println(x + " is a palindrome");
//	        else
//	            System.out.println(x + " is not a palindrome");
//	    }
//	}
	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the number");
	    String str = String.valueOf(sc.nextInt());
	    boolean isPalin = isPalindrome(str, 0, str.length() - 1);
	    if (isPalin) {
	        System.out.println("The number is a palindrome");
	    }
	    else {
	        System.out.println("The number is not a palindrome");
	    }
	}

	private static boolean isPalindrome(String num, int i, int j) {
	    if (i >= j) {
	        return true;
	    }
	    return num.charAt(i) == num.charAt(j) && isPalindrome(num, i + 1, j - 1);
	}
}
	
//public static void main(String[] args) throws IOException {
//Scanner in = new Scanner(System.in);
//System.out.print("Please enter a word: ");
//String word = in.nextLine();
//System.out.print("Please enter a character: ");
//char ch = (char) System.in.read();
//System.out.println("\nNumber of occurrences of given character: "+count(word, ch));
//}
//}