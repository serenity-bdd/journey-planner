package planner.screenplay.model;

public class TripDetails {
    private final String itinerary;
    private final String departureTime;

    public TripDetails(String itinerary, String departureTime) {
        this.itinerary = itinerary;
        this.departureTime = departureTime;
    }

    public String getItinerary() {
        return itinerary;
    }

    public String getDepartureTime() {
        return departureTime;
    }
}
