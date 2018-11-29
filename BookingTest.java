package ie.lyit.flight;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ie.lyit.flight.Passenger;
import ie.lyit.flight.Booking;
import ie.lyit.flight.Flight;


public class BookingTest {
	Booking b1;
	Flight in, out;
	ArrayList<Passenger> passengers;
	Passenger p1;
	

	@Before
	public void setUp() throws Exception {
		// Construct in, out, passengers...
		in = new Flight("F1230","Donegal", "Dublin", 10,10,2018, 11,11,11);
		out = new Flight("F4560","Dublin", "Donegal", 11,11,2018, 10,10,10);
		passengers = new ArrayList<Passenger>();
		p1 = new Passenger("Ms", "Lisa", "Simpson", 10,10,1985, 2, false);
		passengers.add(p1);
		b1 = new Booking(in, out, passengers);
	}
	
	@Test
	public void testBookingInfo() {
		// FIRST TEST
		assertEquals(b1.getInbound(), out );
		assertEquals(b1.getOutbound(), in );
		assertEquals(b1.getPassengers(), passengers );
		
		// SECOND TEST
//		b2=new Booking("Ms","Lisa","Simpson",
//				        20,12,1992,new Date(1,1,2009),25000);
//		
//		assertEquals(b1.getDateProbationEnds(50), new Date(20,2,2009));
	}
	@Test
	public void testSetOutbound() {
		Flight f1 = new Flight("F2340","Dublin", "London", 03,3,2019, 9,9,9);
		b1.setOutBound(f1);
		assertEquals(b1.getOutbound(), f1);
	}
	
	@Test
	public void testSetInbound() {
		Flight f1 = new Flight("F5670","London", "Dublin", 04,04,2019, 12,12,12);
		b1.setOutBound(f1);
		assertEquals(b1.getOutbound(), f1);
	}
	
	@Test
	public void testSetPassenger() {
		ArrayList<Passenger> p2 = new ArrayList<Passenger>();
		b1.setPassengers(p2);
		assertEquals(b1.getPassengers(), p2 );
	}
	
	
	@Test
	public void testFindPassenger() {
		assertTrue(b1.findPassenger(p1) );
	}
	
	@Test
	public void testCalcPrice(){
		double endPrice = passengers.size() * (in.getPrice() + out.getPrice() );
		b1.calcPrice();
		assertEquals(endPrice, b1.getTotalPrice(), 0.0 );
	}
	
	@Test
	public void testSetTotalPrice() {
		double endPrice = passengers.size() * (in.getPrice() + out.getPrice() );
		b1.calcPrice();
		assertEquals(endPrice, b1.getTotalPrice(), 0.0 );
	}
	
	@Test
	public void testToString() {
		String output = "";
//		String output = "Outbound Flight is: " + getOutbound() +
//				   "Inbound Flight is: " + getInbound() +
//				   "Passenger is: " + getPassengers() +
//				   "Total Price is " + getTotalPrice();
//		
		assertTrue(b1.toString().equals(output) );
	}
	
	@Test
	public void testEquals() {
		Booking b2 = b1;
		assertTrue(b1.equals(b2) );
	
	}
}
