package org.ies.tierno.objects.aerolinea;

import org.ies.tierno.objects.aerolinea.reader.random.AirlineRandomer;
import org.ies.tierno.objects.aerolinea.reader.random.FlightRandomer;
import org.ies.tierno.objects.aerolinea.reader.random.PassengerRandomer;
import org.ies.tierno.objects.aerolinea.app.AirlineAppMenu;

import java.util.Scanner;
import java.util.Random;

public class AirlineAppMenuMain {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        PassengerRandomer passengerReader = new PassengerRandomer(random);
        FlightRandomer flightReader = new FlightRandomer(random, passengerReader);
        AirlineRandomer airlineReader = new AirlineRandomer(random, flightReader);
        AirlineAppMenu airlineApp = new AirlineAppMenu (scanner, airlineReader);

        airlineApp.run();
    }
}
