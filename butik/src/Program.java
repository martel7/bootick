import butik.Butik;
import entiteti.*;
import niti.Citac;
import niti.Upisivac;

import java.util.Arrays;
import java.util.List;

public class Program {

    //inicijalizovanje testnih podataka
    private Butik jasmina = new Butik("Jasmina", "Karadjordjeva 13", TipGarderobe.KLASICNA);
    private Butik nSport = new Butik("nSport", "Nikole Pasica 22", TipGarderobe.SPORTSKA);
    private Butik svetMode = new Butik("svetMode", "Lole Ribara 1", TipGarderobe.MODERNA);

    private Prodavac prodavac1 = new Prodavac("Marko", "Markovic", 51000, jasmina);
    private Prodavac prodavac2 = new Prodavac("Ana", "Ivanovic", 49000, jasmina);
    private Prodavac prodavac3 = new Prodavac("Nikola", "Nikolic", 52000, jasmina);
    private Prodavac prodavac4 = new Prodavac("Milica", "Milic", 49500, jasmina);
    private Prodavac prodavac5 = new Prodavac("Stefan", "Stefanovic", 50500, nSport);
    private Prodavac prodavac6 = new Prodavac("Jovana", "Jovanovic", 50000, nSport);
    private Prodavac prodavac7 = new Prodavac("Dragan", "Dragic", 51000, nSport);
    private Prodavac prodavac8 = new Prodavac("Sara", "Saric", 49500, nSport);
    private Prodavac prodavac9 = new Prodavac("Petar", "Petrovic", 51500, svetMode);
    private Prodavac prodavac10 = new Prodavac("Jelena", "Jovanovic", 49000, svetMode);
    private Prodavac prodavac11 = new Prodavac("Vladimir", "Stevanovic", 50500, svetMode);
    private Prodavac prodavac12 = new Prodavac("Tamara", "Ilic", 51000, svetMode);

    private List<Prodavac> prodavci = Arrays.asList(prodavac1, prodavac2, prodavac3,
            prodavac4, prodavac5, prodavac6, prodavac7, prodavac8, prodavac9, prodavac10, prodavac11, prodavac12);

    Odeca odeca1 = new Odeca("Majica", 999.99, 10, "Crvena", "Nike");
    Odeca odeca2 = new Odeca("Farmerke", 1499.99, 5, "Plava", "Under armour");

    Obuca obuca1 = new Obuca("Patike", 2899.99, 15, 42.0, "Guma");
    Obuca obuca2 = new Obuca("Cipele", 4299.99, 8, 39.5, "Koza");

    Kozmetika kozmetika1 = new Kozmetika("Šampon", 499.99, 20, "Šampon za kosu", true);
    Kozmetika kozmetika2 = new Kozmetika("Krema", 199.99, 30, "Hidratantna krema", false);

    Aksesoar aksesoar1 = new Aksesoar("Šešir", 899.99, 10, "Letnji šešir");
    Aksesoar aksesoar2 = new Aksesoar("Torba", 599.99, 5, "Torba za svaku priliku");

    public void zapocniProgram() {
        Upisivac upisivac = new Upisivac(prodavci);
        Thread nitZaUpisivanje = new Thread(upisivac);
        nitZaUpisivanje.start();

        Citac citac = new Citac();
        Thread citacNit = new Thread(citac);
        citacNit.start();

        jasmina.setOsoblje(Arrays.asList(prodavac1, prodavac2, prodavac3, prodavac4));
        nSport.setOsoblje(Arrays.asList(prodavac5, prodavac6, prodavac7, prodavac8));
        svetMode.setOsoblje(Arrays.asList(prodavac9, prodavac10, prodavac11, prodavac12));

        jasmina.dodajProizvod(obuca1);
        jasmina.dodajProizvod(odeca1);
        jasmina.dodajProizvod(aksesoar1);

        nSport.dodajProizvod(obuca2);
        nSport.dodajProizvod(odeca2);
        nSport.dodajProizvod(aksesoar2);

        svetMode.dodajProizvod(kozmetika1);
        svetMode.dodajProizvod(kozmetika2);

        jasmina.stampajInventar();
        nSport.stampajInventar();
        svetMode.stampajInventar();
    }
}
