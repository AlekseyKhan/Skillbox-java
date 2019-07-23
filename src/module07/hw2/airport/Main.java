package module07.hw2.airport;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        airport.getTerminals().stream()
                .flatMap(flight -> flight.getFlights().stream())
                .filter(f -> f.getType() == Flight.Type.DEPARTURE)
                .filter(f -> {
                    LocalTime reysTime = f.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
                    LocalTime currentTime = LocalTime.now();

                    return reysTime.isAfter(currentTime) && reysTime.isBefore(currentTime.plusHours(2));
                })
                .forEach(reys -> {
                    LocalTime departureTime = reys.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
                    System.out.printf("Время вылета %02d:%02d, модель самолета - %s\n",
                            departureTime.getHour(),
                            departureTime.getMinute(),
                            reys.getAircraft());
                })
        ;

    }
}
