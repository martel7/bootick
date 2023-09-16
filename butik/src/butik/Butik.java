package butik;

import entiteti.*;

import java.util.ArrayList;
import java.util.List;

public class Butik {

    public String naziv;
    public String adresa;
    public TipGarderobe tipGarderobe;
    public List<Prodavac> osoblje;
    public List<Obuca> obuca = new ArrayList<>();
    public List<Odeca> odeca = new ArrayList<>();
    public List<Aksesoar> aksesoar = new ArrayList<>();
    public List<Kozmetika> kozmetika = new ArrayList<>();

    public Butik(String naziv, String adresa, TipGarderobe tipGarderobe) {
        this.adresa = adresa;
        this.naziv = naziv;
        this.tipGarderobe = tipGarderobe;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public TipGarderobe getTipGarderobe() {
        return tipGarderobe;
    }

    public void setTipGarderobe(TipGarderobe tipGarderobe) {
        this.tipGarderobe = tipGarderobe;
    }

    public List<Prodavac> getOsoblje() {
        return osoblje;
    }

    public void setOsoblje(List<Prodavac> osoblje) {
        //ukoliko je prilikom setovanja osoblja, broj objekata u listi manji od 4,
        //baca se exception sa odgovarajucom porukom i zavrsava se rad programa
        //Korak 3. iz zadatka
        if(osoblje.size() > 3){
            this.osoblje = osoblje;
            System.out.println("Butik " + naziv + " zadovoljava broj prodavaca.");
        } else {
            throw new RuntimeException("Butik " + naziv + " nema dovoljan broj radnika. Kraj programa.");
        }
    }

    public List<Obuca> getObuca() {
        return obuca;
    }

    public void setObuca(List<Obuca> obuca) {
        this.obuca = obuca;
    }

    public List<Odeca> getOdeca() {
        return odeca;
    }

    public void setOdeca(List<Odeca> odeca) {
        this.odeca = odeca;
    }

    public List<Aksesoar> getAksesoar() {
        return aksesoar;
    }

    public void setAksesoar(List<Aksesoar> aksesoar) {
        this.aksesoar = aksesoar;
    }

    public List<Kozmetika> getKozmetika() {
        return kozmetika;
    }

    public void setKozmetika(List<Kozmetika> kozmetika) {
        this.kozmetika = kozmetika;
    }

    public void prikaziProizvod(Proizvod p){
        System.out.println(p);
    }

    //metoda za dodavanje proizvoda u odgovarajucu listu:
    //Koristimo prednosti OOP-a i nasledjivanja tako sto saljemo objekat koji je tipa Proizvod
    //a posto svi ostali prozivodi nasledjuju klasu Proizvod, mozemo da ispitamo
    //kog su tipa sa `instanceof` i po tome da ih ubacimo u odg. listu
    public void dodajProizvod(Proizvod proizvod){
        if(proizvod instanceof Obuca){
            obuca.add((Obuca) proizvod);
        } else if (proizvod instanceof Odeca) {
            odeca.add((Odeca) proizvod);
        } else if (proizvod instanceof Kozmetika) {
            kozmetika.add((Kozmetika) proizvod);
        } else if (proizvod instanceof Aksesoar) {
            aksesoar.add((Aksesoar) proizvod);
        }
    }

    //Ista stvar, samo za izbacivanje iz odg. liste
    public void izbaciProizvod(Proizvod proizvod) {
        if (proizvod instanceof Obuca) {
            obuca.remove((Obuca) proizvod);
        } else if (proizvod instanceof Odeca) {
            odeca.remove((Odeca) proizvod);
        } else if (proizvod instanceof Kozmetika) {
            kozmetika.remove((Kozmetika) proizvod);
        } else if (proizvod instanceof Aksesoar) {
            aksesoar.remove((Aksesoar) proizvod);
        }
    }

    //za sledece 4. metode smo mogli isto da koristimo neki princip nasledjivanja u OOP-u,
    //ali sam ostavio ovako da bi se metode zvale tacno "prikaziObucu", odecu itd.

    //metoda za prikazivanje sve obuce:
    public void prikaziObucu() {
        System.out.println("Obuca u butiku " + naziv);
        for (Obuca proizvod : obuca) {
            System.out.println(proizvod);
        }
    }

    //metoda za prikazivanje sve odece:
    public void prikaziOdecu(String nazivButika) {
        System.out.println("Odeca u butiku " + nazivButika);
        for (Odeca proizvod : odeca) {
            System.out.println(proizvod);
        }
    }

    //metoda za prikazivanje svih aksesoara:
    public void prikaziAksesoare(String nazivButika) {
        System.out.println("Aksesoar u butiku " + nazivButika);
        for (Aksesoar proizvod : aksesoar) {
            System.out.println(proizvod);
        }
    }

    //metoda za prikazivanje sve kozmetike:
    public void prikaziKozmetiku(String nazivButika) {
        System.out.println("Kozmetika u butiku " + nazivButika);
        for (Kozmetika proizvod : kozmetika) {
            System.out.println(proizvod);
        }
    }

    public void stampajInventar() {
        System.out.println("Inventar butika " + naziv + ":");
        if(!odeca.isEmpty()){
            stampajCeluListu(odeca);
        }
        if(!obuca.isEmpty()){
            stampajCeluListu(obuca);
        }
        if(!aksesoar.isEmpty()){
            stampajCeluListu(aksesoar);
        }
        if(!kozmetika.isEmpty()){
            stampajCeluListu(kozmetika);
        }
    }

    //pomocna metoda za stampanje bilo koje liste, za to sluzi ovaj upitnik, umesto da specificiramo
    //`odeca`, `obuca` itd, mozemo samo da stavimo ? i da se referenciramo na taj tip kao Object,
    //jer je svaka klasa u javi podtip Object-a
    private void stampajCeluListu(List<?> listProizvoda){
        for(Object p : listProizvoda){
            System.out.println(p.toString());
        }
    }
}
