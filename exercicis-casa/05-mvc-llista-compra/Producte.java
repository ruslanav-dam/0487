/**
 * MODEL: Producte
 *
 * Representa un producte amb nom i preu.
 *
 * @author La Salle Tarragona — Exercici Debugging MVC
 */
public class Producte {

    private String nom;
    private double preu;

    public Producte(String nom, double preu) {
        this.nom = nom;
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }
}
