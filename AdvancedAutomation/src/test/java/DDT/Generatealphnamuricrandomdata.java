package DDT;

import java.util.Iterator;

public class Generatealphnamuricrandomdata {

	public static void main(String[] args) {
			int n=20;
			//choose a character random from this string
			String alphanumericstring="ABCDEFGHIJKLMNOPQRSTUVWXZ0123456789abcdefghijklmnopqrstuvwxyz";
			
			//create stringbuffer size of alphanumericstring
			StringBuilder sb=new StringBuilder();
			
			for(int i=0;i<n;i++) {
				//generate a random number between 0 to alphanumericString variable length
				int index=(int)(alphanumericstring.length()*Math.random());
				
				//add character one by one in end of sb
				sb.append(alphanumericstring.charAt(index));
			}
			System.out.println(sb);

	}

}
