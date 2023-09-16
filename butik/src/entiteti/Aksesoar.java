package entiteti;

public class Aksesoar extends Proizvod{

    private String namena;

    public Aksesoar(String naziv, double cena, int kolicina, String namena) {
        super(naziv, cena, kolicina);
        this.namena = namena;
    }

    public String getNamena() {
        return namena;
    }

    public void setNamena(String namena) {
        this.namena = namena;
    }

    @Override
    public String toString() {
        return "Naziv: " + super.getNaziv() +
                ", Cena: " + super.getCena() +
                ", Kolicina: " + super.getKolicina() +
                ", Namena: " + namena;
    }
}
