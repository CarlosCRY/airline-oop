package org.ies.tierno.objects.aerolinea.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Passenger {
    private String nif;
    private String name;
    private String surname;
    private int seat;

    public void showInfo() {
        System.out.println("\n" + surname + ", " + name + ", NIF: " + nif + ". Asiento: " + seat);
    }
}