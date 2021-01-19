package simplifiedSocialNetwork;

import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class SocialNetwork {
	//ArrayList to store the names of the person
	private static ArrayList<String> person = new ArrayList<String>();
	
	//HashMap to store the friends of the person (with person as the key and ArrayList as the friends)
	private static HashMap<String, ArrayList<String>> friend = new HashMap<>();
	
	//BufferedReader object for inputs 
	private static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	
	//method to add person to the list
	static void addPerson() throws IOException {
		String temp;
		boolean flag=true;
		do {
			System.out.print("Enter person name: ");
			temp = buf.readLine();
			if(person.contains(temp)==true) {
				System.out.println("\n!!!Person name exists!!!\n");
				flag = false; break;
			}else {
				flag=true;
			}
		}while(flag==false);
		
		if(flag==true) {
			person.add(temp);
			
			int index = person.size()-1;
			addFriend(index);
			
			System.out.print("Remove friends? (Y/N): ");
			String yes = buf.readLine();
			if(yes.compareToIgnoreCase("Y")==0) {
//				int index = person.size()-1;
				removeFriend(index);
			}
		}
	}
	
	//remove a person from the list as well as the corresponding friend list
	static void removePerson() throws IOException {
		System.out.println("\nRemove person's name: ");
		String remPer = buf.readLine();
		if(person.contains(remPer)==false) {
			System.out.print("\n!!Person does not exist!!");
		}else {
			person.remove(person.indexOf(remPer));
			friend.remove(remPer);
		}
	}
	
	//method to add new friend to the existing person friend list
	static void addFriend(int in) throws IOException {
		ArrayList<String> user = new ArrayList<>();
		String n;
		do {
			System.out.print("\nAdd friend name ('N' to cancel): ");
			n = buf.readLine();
			if(n.compareToIgnoreCase("N")!=0) {
				user.add(new String(n));
			}else {
				break;
			}
		}while(true);
		friend.put(person.get(in), user);
	}
	
	//method to remove a friend from the existing person friend list
	static void removeFriend(int in) throws IOException {
		ArrayList<String> user = new ArrayList<>();
		user = friend.get(person.get(in));
		System.out.print("Old friends: "+user);
		do {
			if(user==null) {
				System.out.print("\n!!No friends!!");
				break;
			}
			System.out.print("\nunFriend name: ('N' to cancel): ");
			String unFriend = buf.readLine();
			if(unFriend.compareToIgnoreCase("N")!=0) {
				if(user.contains(unFriend)==false) {
					System.out.print("\n!!friend does not exist!!");
				}else {
					user.remove(user.indexOf(unFriend));
				}
			}else {
				break;
			}
		}while(true);
		System.out.print("\nNew Friends: "+user);
	}
	
	//method to check the number of friend a person has, max no. of friend a person has, person without friends
	static void checkFriendsNum() {
		int[] count = new int[person.size()];
		int maxCountIndex=0, noneCount=0;
		for(int i=0; i<person.size(); i++) {
			if(friend.get(person.get(i)).size()==0) {
				count[i]=0;
				noneCount++;
			}else {
				count[i] = friend.get(person.get(i)).size();
			}
			System.out.print("\nNo. of friends of "+person.get(i)+": "+count[i]);
			if(count[maxCountIndex]<count[i]) {
				maxCountIndex=i;
			}
		}
		System.out.print("\n"+person.get(maxCountIndex)+" has max "+count[maxCountIndex]+" friends.");
		System.out.print("\nPerson with no friends: "+noneCount);
	}
	
	//method to check the social connection between 2 person if it is mutual or direct
	//sample input as per question
	static void socialConnection() {
		ArrayList<String> x,y,z = new ArrayList<>();
		for(int i=0; i<person.size(); i++) {
			for(int j=i+1; j<person.size(); j++) {//friend.get(person.get(i)).size()
				x=friend.get(person.get(i)); //bob = jim, marry
				y=friend.get(person.get(j)); //marry = bob
				if(x.contains(person.get(j))==true && y.contains(person.get(i))==true) {
					System.out.println("\nDirect connection between: "+person.get(i)+", "+person.get(j));
				}
				for(int k=j+1; k<person.size(); k++) {
					z=friend.get(person.get(k));//jim = bob
					if(y.contains(person.get(i))==true && z.contains(person.get(i))==true){
						System.out.println("\n"+person.get(j)+", "+person.get(k)+" Mutual connect with "+person.get(i));
					}
				}
			}
		}
	}
	
	public static void main(String args[]) {
		try {
			String yes;
			do {
				addPerson();
				System.out.print("\nAdd more person? (Y for yes): ");
				yes = buf.readLine();
			}while(yes.compareToIgnoreCase("Y")==0);
			
			do {
				System.out.print("\nWant to remove a person?(Y for yes): ");
				yes = buf.readLine();
				if(yes.compareToIgnoreCase("Y")==0) {
					removePerson();
				}
			}while(yes.compareToIgnoreCase("Y")==0);
			
			
			System.out.println("Total person: "+person.size());
			System.out.println("Person list: ");
			for(int i=0; i<person.size(); i++) {
				System.out.println(person.get(i));
			}
			System.out.println("\nFriends list: "+friend.size());
			System.out.println(friend);
			
			checkFriendsNum();
			
			socialConnection();
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
}
