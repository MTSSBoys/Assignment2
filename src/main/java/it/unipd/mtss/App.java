////////////////////////////////////////////////////////////////////
// Davide Baraldo 2082847
// Alessandro Zainer 2101091
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class App 
{

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        int number;
        String romanRepresentation;

        System.out.print("Inserisci un numero: ");

        try {
            number = scanner.nextInt();
        } catch (NoSuchElementException e) {
            System.err.println("Input non valido");
            return;
        }

        try {
            romanRepresentation = RomanPrinter.print(number);
        } catch (IllegalArgumentException e) {
            System.err.println("Input fuori dal range [1, 1000]");
            return;
        }

        System.out.println(romanRepresentation);
    }
}
