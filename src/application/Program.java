package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check In Date: ");
		Date date1 = sdf.parse(sc.next());
		System.out.print("Check Out Date: ");
		Date date2 = sdf.parse(sc.next());

		if (!date2.after(date1)) {
			System.out.println("Error in Reservation. Check out Date must be after check in date");
		} else {
			Reservation reservation = new Reservation(number, date1, date2);
			System.out.println(reservation);

			System.out.print("Enter data to update Reservation: ");

			System.out.print("Check In Date: ");
			Date dateU1 = sdf.parse(sc.next());
			System.out.print("Check Out Date: ");
			Date dateU2 = sdf.parse(sc.next());

			Date now = new Date();
			if (dateU1.before(now) || dateU2.before(now)) {
				System.out.println("Error in Reservation: REservation dates for update must be future");

			} else if (!dateU2.after(dateU1)) {
				System.out.println("Error in Reservation: Check out Date must be after check in date");
			} else {
				reservation.updateDates(dateU1, dateU2);
				System.out.println("Reservation: "+reservation);
			}
			
			

			sc.close();

		}

	}
}
