package niti;

import entiteti.Prodavac;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Upisivac implements Runnable{

    List<Prodavac> prodavci;

    //setovanje liste prodavaca kroz konstruktor, zato sto run() metoda koju moraju da imaju sve Runnable
    //klase (Niti) ne sme da prima nikakve argumente -> mora da bude run(), ne moze run(List<Prodavac> prodavci)
    public Upisivac(List<Prodavac> prodavci){
        this.prodavci = prodavci;
    }

    @Override
    public void run() {
        //obican try catch blok gde ce se u Catch delu hvatati IOException
        //ukoliko neka od akcija sa fajlovima ne bude uspesna, zavrsava se izvrsavanje programa
        try {
            File fajl = new File(System.getProperty("user.dir") + "/prodavci.txt");
            if (!fajl.exists()) {
                fajl.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fajl));

            for (Prodavac p : prodavci) {
                bufferedWriter.write(p.toString() + "\n");
            }

            bufferedWriter.close();

            System.out.println("Prodavci uspesno upisani u fajl.");
        } catch (IOException e) {
            throw new RuntimeException("Desila se greska prilikom upisa u fajl: " + e);
        }
    }
}
