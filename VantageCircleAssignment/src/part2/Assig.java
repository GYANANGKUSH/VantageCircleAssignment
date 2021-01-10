package part2;
import java.util.*;
import java.io.*;

public class Assig {
	static void sums(int arr[], int val) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<arr.length; i++) {
			int xx = val - arr[i];
			if(set.contains(xx)) {
				System.out.println("Pairs: "+arr[i]+" "+xx);
			}
			else {
				set.add(arr[i]);
			}
		}
	}
	public static void main(String args[]) {
		try {
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter array length:\n");
			int len = Integer.parseInt(buf.readLine());
			int arr[] = new int[len]; int i=0;
			
			System.out.println("Enter the array:\n");
	 		for(i=0; i<len; i++) {
	 			arr[i]=Integer.parseInt(buf.readLine());
	 		}
	 		System.out.println("Enter sum value:\n");
 	 		int val = Integer.parseInt(buf.readLine());
 	 		
 	 		System.out.println("Your array is: ");
 	 		i=0;
 	 		while(i<len) {
 	 			System.out.print(arr[i]+" ");
 	 			i++;
 	 		}
 	 		
 	 		System.out.println("\nYour sum value is: "+val+"\n");
 	 		
 	 		sums(arr, val);
		}catch(Exception ex)
		{ System.out.println("Error: "+ex);}
	}
}
