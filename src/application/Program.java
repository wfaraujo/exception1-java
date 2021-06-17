package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			System.out.print("Check In Date: ");
			Date date1 = sdf.parse(sc.next());
			System.out.print("Check Out Date: ");
			Date date2 = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, date1, date2);
			System.out.println(reservation);
	
			System.out.print("Enter data to update Reservation: ");
	
			System.out.print("Check In Date: ");
			Date dateU1 = sdf.parse(sc.next());
			System.out.print("Check Out Date: ");
			Date dateU2 = sdf.parse(sc.next());
	
			reservation.updateDates(dateU1, dateU2);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e ) {
			System.out.println("Invalid date format");
		}
		
		catch (DomainExceptions e) {
			System.out.println("Error in reservatio: "+e.getMessage());
		}
		
		catch(RuntimeException e) {
			System.out.println("Unexpected Error");
		}

		sc.close();

		}
}
