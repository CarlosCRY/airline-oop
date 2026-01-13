package org.ies.tierno.objects.aerolinea.reader.scanner;

import org.ies.tierno.objects.aerolinea.model.Passenger;
import org.ies.tierno.objects.aerolinea.reader.PassengerReader;

import java.util.Scanner;

public class PassengerScannerer implements PassengerReader {

    private final Scanner scanner;

    public PassengerScannerer(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Passenger read() {
        System.out.println("\nIntroduzca los datos del propietario:");

        System.out.println("NIF\n");
        String nif = scanner.nextLine();

        System.out.println("\nNombre\n");
        String name = scanner.nextLine();

        System.out.println("\nApellidos\n");
        String surname = scanner.nextLine();

        System.out.println("\nAsiento\n");
        int seat = scanner.nextInt();
        scanner.nextLine();

        return new Passenger(nif, name, surname, seat);
    }
}
