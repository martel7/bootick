package niti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Citac implements Runnable {
    @Override
    public void run() {
        //Sleep block, mora da ide u try-catch jer Thread.sleep(millis) baca InterruptedException
        //Ukoliko se baci exception, zavrsava se izvrsavanje programa.
        try {
            System.out.println("Nit koja cita iz fajla je startovana. Ceka 6 sekundi...");
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //obican try catch blok gde ce se u Catch delu hvatati IOException
        //ukoliko neka od akcija sa fajlovima ne bude uspesna, zavrsava se izvrsavanje programa
        try {
            System.out.println("Citanje iz fajla...");
            String putanja = System.getProperty("user.dir") + "/prodavci.txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(putanja));
            String linija;
            while ((linija = bufferedReader.readLine()) != null) {
                String[] delovi = linija.split(";");

                if (delovi.length == 4) {
                    String ime = delovi[0];
                    String prezime = delovi[1];
                    float plata = Float.parseFloat(delovi[2]);
                    String butik = delovi[3];

                    System.out.println("Ime: " + ime);
                    System.out.println("Prezime: " + prezime);
                    System.out.println("Plata: " + plata);
                    System.out.println("Butik: " + butik);
                    System.out.println();
                } else {
                    System.out.println("Nevažeći red: " + linija);
                }
            }
            System.out.println("Citanje iz fajla zavrseno.");
        } catch (IOException e) {
            throw new RuntimeException("Desila se greska prilikom citanja iz fajla: " + e);
        }
    }
}
