/**
 * @author		DJ Kim <djkim@cs.ucla.edu>
 *
 * CS 130 Fall 2016
 *
 * Created to illustrate a real-life example of Mediator Design Pattern
 * Air Traffic Controller controls all of the incoming flights and make
 * sure the runway is open for landing. All of the incoming flights 
 * communicates to the ATC and ATC communicates to runway. Incoming flights
 * and runway never directly communicates. Assume that this airport is small
 * and has only one runway.
 *
 */

// Mediator
public interface Mediator {
	public void addRunway(Runway runway);

	public void addFlight(Flight flight);

	public void removeFlight(Flight flight);

	public boolean isLandingOk();

	public void setLandingStatus(boolean isLandingOk);
}

// ConcreteMediator
public class AirTrafficController implements Mediator {
	private Arraylist<Flight> flights = new ArrayList();
	private Runway runway;
	private boolean isLandingOk;

	public void addRunway(Runway runway) {
		this.runway = runway;
	}

	public void addFlight(Flight flight) {
		flights.add(flight);
	}

	public void removeFlight(Flight flight) {
		flights.remove(flight);
	}

	public boolean isLandingOk() {
		return isLandingOk;
	}

	public void setLandingOk(boolean isLandingOk) {
		this.isLandingOk = isLandingOk;
	}
}

// Colleague
public interface Colleague {
	void land();
}

// ConcreteColleague
public class Flight implements Colleague {
	private Mediator mediator;

	public Flight(Mediator mediator) {
		this.mediator = mediator;
	}

	public void land() {
		// cleared to land
		if (mediator.isLandingOk()) {
			System.out.println("Cleared to land. Landing in progress");
			// since the flight is about to land on the runway, set the landing status to false
			mediator.setLandingStatus(false);
		} else {
			// not cleared to land
			System.out.println("Not cleared to land. Waiting for the clear");
		}
	}

	public void landingDone() {
		System.out.println("Successfully landed");
		mediator.setLandingStatus(true);
		// remove the flight from the landing queue
		mediator.removeFlight(this);
	}
}

public class Runway implements Colleague {
	private Mediator mediator;

	public Runway(Mediator mediator) {
		this.mediator = mediator;
		mediator.setLandingStatus(true);
	}

	public void land() {
		System.out.println("Runway open for landing");
		mediator.setLandingStatus(true);
	}
}