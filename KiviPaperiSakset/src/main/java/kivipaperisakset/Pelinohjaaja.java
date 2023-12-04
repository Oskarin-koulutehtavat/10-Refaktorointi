package kivipaperisakset;

/**
 * Pelinohjaaja käsittelee pelien ja kierrosten pelaamisen sekä pelien tilastot
 * @author Oskari Pahkala
 */
public class Pelinohjaaja {
	/**
	 * {@link Pelaaja} 1
	 */
	private Pelaaja pelaaja1;
	/**
	 * {@link Pelaaja} 2
	 */
	private Pelaaja pelaaja2;
	/**
	 * Pelattujen pelien lkm
	 */
    private int pelatutKierrokset = 0;
    /**
     * Tasapelien lkm
     */
    private int tasapelit = 0;
    
    /**
     * Luo pelinohjaajan 
     * @param p1 {@link Pelaaja} 1
     * @param p2 {@link Pelaaja} 2
     */
    public Pelinohjaaja(Pelaaja p1, Pelaaja p2) {
		this.pelaaja1 = p1;
		this.pelaaja2 = p2;
	}
    
    /**
     * Tulostaa pelin tilastot
     */
    private void tulostaTilasto() {
    	System.out.println("Erä: " + (pelatutKierrokset + 1) + " =====================");
    	System.out.println();
        System.out.println("Tasapelien lukumäärä: " + tasapelit);
        System.out.println("Pelaaja 1:llä koossa " + pelaaja1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2:lla koossa " + pelaaja2.getVoitot() + " voittoa.");
        System.out.println();
    }
    
    /**
     * Tarkistaa kumpi pelaaja voittaa
     * @param p1 {@link Pelaaja} 1
     * @param p2 {@link Pelaaja} 2
     * @return voittavan {@link Pelaaja pelaajan}, tai null jos tasapeli
     */
    private static Pelaaja tarkistaVoittaja(Pelaaja p1, Pelaaja p2) {
    	// Pelaajat tekevät valintansa
    	Valinnat p1Valinta = p1.pelaajanValinta();
    	Valinnat p2Valinta = p2.pelaajanValinta();
        
    	if (p1.getNimi() != null && p2.getNimi() != null) {    		
    		System.out.println(p1.getNimi() + ": " + p1Valinta);
    		System.out.println(p2.getNimi() + ": " + p2Valinta);
    	}
    	
    	if // Tarkista voittiko pelaaja 1
        ((p1Valinta.equals(Valinnat.KIVI))	&&	(p2Valinta.equals(Valinnat.SAKSET)) ||
         (p1Valinta.equals(Valinnat.PAPERI))	&&	(p2Valinta.equals(Valinnat.KIVI)) ||
         (p1Valinta.equals(Valinnat.SAKSET))	&&	(p2Valinta.equals(Valinnat.PAPERI))) {
            return p1;
        } else if // Tarkista voittiko pelaaja 2
        ((p2Valinta.equals(Valinnat.KIVI))		&&	(p1Valinta.equals(Valinnat.SAKSET)) ||
         (p2Valinta.equals(Valinnat.PAPERI))	&&	(p1Valinta.equals(Valinnat.KIVI)) ||
         (p2Valinta.equals(Valinnat.SAKSET))	&&	(p1Valinta.equals(Valinnat.PAPERI))){
        	return p2;
        }
    	// muussa tilanteessa tasapeli
    	return null;
    }
    
    /**
     * Pelaa yhden kierroksen
     */
    private void pelaaKierros() {
        
        Pelaaja voittaja = tarkistaVoittaja(pelaaja1, pelaaja2);
        
        if (voittaja == null) {
            tasapelit++;
            System.out.println("Tasapeli");
        } else {
        	System.out.println(voittaja.getNimi() + " voittaa");
        	voittaja.setVoitot();
        }
        System.out.println();

        pelatutKierrokset++;
    }
    
    /**
     * Pelaa kokonaisen pelin
     * @param voitot Pelin voittamiseen tarvittava voitettujen kierrosten lukumäärä
     */
    public void pelaaPeli(int voitot) {
    	// Pelaa kierroksia kunnes toisella palaajalla on tarpeeksi voittoja
    	do {
    		tulostaTilasto();
            
            pelaaKierros();
            
        } while ((pelaaja1.getVoitot() < voitot) && (pelaaja2.getVoitot() < voitot));
    	
    	System.out.println(voitot + " VOITTOA - PELI PÄÄTTYY\n");
    }
}
