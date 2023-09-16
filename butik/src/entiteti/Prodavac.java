package entiteti;

import butik.Butik;

public class Prodavac {

    public String ime;
    public String prezime;
    public float plata;
    public Butik butik;

    public Prodavac(String ime, String prezime, float plata, Butik butik) {
        this.ime = ime;
        this.prezime = prezime;
        this.plata = plata;
        this.butik = butik;
    }

    //Override ugradjene toString metode, kojom uredjujemo String reprezentaciju objekta
    //koju cemo kasnije pozivati za upisivanje iz fajla. ";" ce biti delimiter kasnije
    //po kom cemo da splitujemo liniju iz .txt fajla
    @Override
    public String toString() {
        return ime + ";" + prezime + ";" + plata + ";" + butik.getNaziv();
    }
}
