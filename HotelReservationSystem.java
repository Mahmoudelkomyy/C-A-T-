import java.util.*;
class Room{ //default access modifier
	public int singleRooms;
	public int doubleRooms;
	public int deluxeRooms;
	public int cabanas;
	public int suites;
	public Room(){ //constructor
		singleRooms = 100;
		doubleRooms = 75;
		deluxeRooms = 50;
		cabanas = 25;
		suites = 6;
	} //random numbers
	public void getAvailableRooms(){
		System.out.println("Single Rooms: " + singleRooms);
		System.out.println("Double Rooms: " + doubleRooms);
		System.out.println("Deluxe Rooms: " + deluxeRooms);
		System.out.println("Cabanas: " + cabanas);
		System.out.println("Suites: " + suites);
	}
	public void setRoom(String s, int n){
		switch(s){
		case "Single":
			singleRooms -= n;
			break;
		case "Double":
			doubleRooms -= n;
			break;
		case "Deluxe":
			deluxeRooms -= n;
			break;
		case "Cabana":
			cabanas -= n;
			break;
		case "Suite":
			suites -= n;
			break;
		}
	}
}

public class HotelReservationSystem {
	
	private Room availableRooms ;
	String bookingDetails;
	String[] arr = new String[5];
	int bookingDetailsIndex;
	public HotelReservationSystem(){ //constructor
		availableRooms = new Room();
		bookingDetails = "You Didn't Reserve Yet";
		bookingDetailsIndex = 0;
	}
	public void roomReservation(){
		Scanner x = new Scanner(System.in);
		String room = "";
		System.out.println("Which Room Type Do You Want To Reserve?");
			System.out.println("a)Single" + "\n" + "b)Double" + "\n" + "c)Deluxe" + "\n" + "d)Cabana"  + "\n" + "e)Suite");
		String input = x.nextLine();

		boolean b = true;
		int n = 0; //n=0 doesn't mean anything, java just won't work without initializing it
		switch(input){
		case "a":
			System.out.println("Available Single Rooms: " + availableRooms.singleRooms);
			n = availableRooms.singleRooms;
			room = "Single";
			break;
		case "b":
			System.out.println("Available Double Rooms: " + availableRooms.doubleRooms);
			n = availableRooms.doubleRooms;
			room = "Double";
			break;
		case "c":
			System.out.println("Available Deluxe Rooms: " + availableRooms.deluxeRooms);
			n = availableRooms.deluxeRooms;
			room = "Deluxe";
			break;
		case "d":
			System.out.println("Available Cabanas: " + availableRooms.cabanas);
			n = availableRooms.cabanas;
			room = "Cabana";
			break;
		case "e":
			System.out.println("Available Suites: " + availableRooms.suites);
			n = availableRooms.suites;
			room = "Suite";
			break;
		default:

			System.out.println("Wrong Input, Repeat The Process");
			b = false;
			break;
		}
		if(b){
			System.out.println("How Many Rooms Do You Want?");
			int wantedRooms = x.nextInt();
			if(wantedRooms == 0)
				System.out.println("You Want 0 Rooms?! Are You Kidding, We Are Working Here");
			else{
				if(n > wantedRooms){
					availableRooms.setRoom(room, wantedRooms);
					if(wantedRooms == 1)
						bookingDetails = "Booking Details: 1 Room Of Type " + room + " Reserved On " + getDate();
					else
						bookingDetails = "Booking Details: " + wantedRooms + " Rooms Of Type " + room + " Reserved On " + getDate();
				}
				else
					System.out.println("The Number Of Rooms You Want Is More Than The Available Ones");
			}
		}
		arr[bookingDetailsIndex] = bookingDetails;
		bookingDetailsIndex++;
	}
	public void getBookingDetails(){
		for(int i =0; i <(bookingDetailsIndex); i++)
			System.out.println(arr[i]);
	}
	public Date getDate(){
		Date d = new Date();
		return d;
	}
	public static void main(String[]args){
		Scanner x = new Scanner(System.in);
		HotelReservationSystem hotel = new HotelReservationSystem();
		System.out.println("Hello, Choose An Option From The Following");
		do{
			System.out.println("a)Search For Available Rooms"+"\n"+"b)Make Reservations"+"\n"+"c)View Booking Details"+"\n"+"d)Exit");
			String answer = x.nextLine();
			if(answer.equalsIgnoreCase("a"))
				hotel.availableRooms.getAvailableRooms();
			else if(answer.equalsIgnoreCase("b"))
				hotel.roomReservation();
			else if(answer.equalsIgnoreCase("c"))
				hotel.getBookingDetails();
			else if(answer.equalsIgnoreCase("d"))
				break;
			else
				System.out.println("Wrong Choice, Try Again");

			System.out.println("Do You Want To Choose Another Option? (Yes/No)");
			String choice = x.nextLine();
			if(choice.equalsIgnoreCase("no")){
				System.out.println("Thank You For Choosing Our Hotel");
				break;
			}
		}while(true); //each repetition is considered a new booking for the same customer, with available rooms changing
	}
} //when the do-while loop ends the system is reset, and the available rooms returns to its initial value