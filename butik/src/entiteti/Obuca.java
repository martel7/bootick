package entiteti;

public class Obuca extends Proizvod{

    private double broj;
    private String materijal;

    public Obuca(String naziv, double cena, int kolicina, double broj, String materijal) {
        super(naziv, cena, kolicina);
        this.broj = broj;
        this.materijal = materijal;
    }

    public double getBroj() {
        return broj;
    }

    public void setBroj(double broj) {
        this.broj = broj;
    }

    public String getMaterijal() {
        return materijal;
    }

    public void setMaterijal(String materijal) {
        this.materijal = materijal;
    }


    @Override
    public String toString() {
        return "Naziv: " + super.getNaziv() +
                ", Cena: " + super.getCena() +
                ", Kolicina: " + super.getKolicina() +
                ", Broj: " + broj +
                ", Materijal: " + materijal;
    }
}
