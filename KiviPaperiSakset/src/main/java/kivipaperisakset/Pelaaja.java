
package kivipaperisakset;

import java.util.Random;

/**
 * Pelaaja tekee valintoja ja muistaa voittonsa
 * @author Ira Dook
 */
public class Pelaaja {
	/**
	 * Voittojen lukumäärä
	 */
    private int voitot = 0;
    /**
	 * Nimi
	 */
    private String nimi;

    /**
	 * Satunnaisluku generaattori
	 */
	private Random random = new Random();

	/**
	 * Luo pelaajan
	 * @param nimi Nimi
	 */
    public Pelaaja(String nimi) {
    	this.nimi = nimi;
    }
    
    /**
     * Valitse satunnaisesti kivi, paperi tai sakset
     * @return Pelaajan tekemä {@link Valinnat valinta}
     */
    public Valinnat pelaajanValinta() {
    	Valinnat[] valinnat = Valinnat.values();
    	return valinnat[random.nextInt(valinnat.length)]; // Palauta satunnainen valinta
    }

    /**
     * Lisää yhden voiton pelaajalle
     */
    public void setVoitot() {
        voitot++;
    }

    /**
     * @return Pelaajan voittojen määrä
     */
    public int getVoitot() {
        return (voitot);
    }

    /**
     * @return Pelaajan nimi
     */
    public String getNimi() {
    	return nimi;
    }
}
