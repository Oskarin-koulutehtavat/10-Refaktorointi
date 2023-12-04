package kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
public class Peli {

	/**
	 * Pääohjelma
	 * @param args Passed command-line arguments
	 */
    public static void main(String[] args) {
        new Pelinohjaaja(new Pelaaja("Pelaaja 1"), new Pelaaja("Palaaja 2")).pelaaPeli(3);
    }
}
