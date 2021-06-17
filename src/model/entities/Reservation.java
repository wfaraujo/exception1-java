package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {

		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	
	public long duration() {
		long dif=checkOut.getTime()-checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
		
		
	}
	
	public void updateDates(Date dateU1, Date dateU2) throws DomainExceptions {
		Date now = new Date();
		if (dateU1.before(now) || dateU2.before(now)) {
			throw new DomainExceptions("REservation dates for update must be future");

		} if (!dateU2.after(dateU1)) {
			throw new DomainExceptions("Check out Date must be after check in date");
		}
		
		this.checkIn=dateU1;
		this.checkOut=dateU2;
		
	}
	
	@Override
	public String toString() {
		return "Reservation: Room "+getRoomNumber()
		+", Check in: "+sdf.format(checkIn)+
		", Check out: "+sdf.format(checkOut)+
		", "+duration()+" nights";
	}

}
