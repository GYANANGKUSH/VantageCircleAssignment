package HotelBook;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class HotelBooking {
	static String customerType = null; //customer type as "reward" or "regular"
	static String bookDate = null; //valid date for booking which later be converted to Date datatype
	static int days = 0; //no.s of days for the booking
	static String[] day; //to store the initial 3 chars of days of a week
	static HotelData[] h = new HotelData[3]; //object array to store the data of various hotel (B&B)
	
	//this method can also be called without the parameter since the parameter passed contains the value of global variable customerType
	//the parameter is used for jUnit testing in testCustomerType.java
	static boolean checkCustomerType(String typ) {
		if(typ.compareToIgnoreCase("reward")!=0 && typ.compareToIgnoreCase("regular")!=0) {
			System.out.println("\n!!reward or regular!!\n");
			return false;
		}else {
			return true;
		}
		//if-else condition for checking the customer type
	}
	
	//method to convert the String (which contains the date) to Date datatype and also check if the input date format is valid
	static boolean checkDate(String d) {
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		dt.setLenient(false);
		try {
			dt.parse(d.trim());
		}catch(ParseException dt_ex) {
			System.out.println("\nPlease enter date in the correct format!!\n");
			return false;
		}
		return true;
	}
	
	//method to accept the inputs
	static void getInput() {
		try {
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.println("\nEnter customer type: ");
				customerType = buf.readLine();
			}while(checkCustomerType(customerType)==false);
			
			do {
				System.out.println("\nEnter booking date(DD/MM/YYYY): ");
				bookDate = buf.readLine();
			}while(checkDate(bookDate)==false);
			
			System.out.println("\nHow many days?: ");
			days = Integer.parseInt(buf.readLine());
		}catch(Exception ex) {
			System.out.println("Error :"+ex);
		}
	}
	
	//method to get the names of days for the given input date
	static String[] getDays(String bdt, int nd)throws Exception {
		//since .parse() is used, exception needs to be handled
		//dbt = book date, nd = no. of days
		
		SimpleDateFormat fmat = new SimpleDateFormat("dd/MM/yyyy");
		Date d = fmat.parse(bdt);//convert string 'bdt' to date datatype
		
		day = new String[nd];

		SimpleDateFormat dFmat = new SimpleDateFormat("EEE");//for extracting the 3 initial chars of a day name
		day[0] = dFmat.format(d);
		
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		for(int i=1; i<nd; i++) {
			c.add(Calendar.DATE, 1);
			Date ndate= c.getTime();
			
			SimpleDateFormat cc = new SimpleDateFormat("EEE");//for extracting the 3 initial chars of a day name
			day[i] = cc.format(ndate);
		}
		return day;
//		for(int i=0; i<nd; i++) {
//			System.out.println(" "+day[i]);
//		}
	}
	
	//method for setting the data for each hotel
	static void setHotelData() {
		h[0] = new HotelData("CoconutValley");
		h[0].setRegWeekday(1100);
		h[0].setRegWeekend(900);
		h[0].setVipWeekday(800);
		h[0].setVipWeekend(800);
		h[0].setStar(3);
		
		h[1] = new HotelData("AakulamLake");
		h[1].setRegWeekday(1600);
		h[1].setRegWeekend(600);
		h[1].setVipWeekday(1100);
		h[1].setVipWeekend(500);
		h[1].setStar(4);
		
		h[2] = new HotelData("VeliBeach");
		h[2].setRegWeekday(2200);
		h[2].setRegWeekend(1500);
		h[2].setVipWeekday(1000);
		h[2].setVipWeekend(400);
		h[2].setStar(5);
	}
	
	//method to find the best and cheapest hotel for customer during the given dates 
	static void findHotel() {
		int[] price = new int[h.length];
		if(customerType.compareToIgnoreCase("regular")==0) {
			for(int j=0; j<h.length; j++) {
				for(int i=0; i<days; i++) {
					if(day[i].compareToIgnoreCase("Sun")==0 || day[i].compareToIgnoreCase("Sat")==0) {
						price[j] += h[j].getRegWeekend();
					}else {
						price[j] += h[j].getRegWeekday();
					}
				}
			}
		}else {
			for(int j=0; j<h.length; j++) {
				for(int i=0; i<days; i++) {
					if(day[i].compareToIgnoreCase("Sun")==0 || day[i].compareToIgnoreCase("Sat")==0) {
						price[j] += h[j].getVipWeekend();
					}else {
						price[j] += h[j].getVipWeekday();
					}
				}
			}
		}
//		for(int i=0; i<h.length; i++) {
//			System.out.println(h[i].getHName() +" " + price[i]);
//		}
		
		int cheapIndex=0, cheap=price[0];
		for(int i=0; i<h.length; i++) {
			if(price[i]<cheap) {
				cheap = price[i];
				cheapIndex = i;
			}else if(cheap==price[i]) {
				if(h[i].getStar()>h[cheapIndex].getStar()) {
					cheapIndex = i;
				}
			}
		}
		System.out.println("Cheapest hotel for you: "+ h[cheapIndex].getHName());
	}
	
	public static void main(String args[]) {
		try {
			getInput();
			day=getDays(bookDate, days);
			
			setHotelData();
			findHotel();
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
}
