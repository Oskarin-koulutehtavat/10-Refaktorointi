import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import kivipaperisakset.Pelaaja;
import kivipaperisakset.Valinnat;

class TestPelaaja {
	@Test
	void lisääVoitto() {
		Pelaaja pelaaja = new Pelaaja(null);
		int before = pelaaja.getVoitot();
		pelaaja.setVoitot();
		assertEquals(pelaaja.getVoitot(), before + 1);
	}
	
	@Test
	void nimiASettuu() {
		String nimi = "Pelaaja";
		Pelaaja pelaaja = new Pelaaja(nimi);
		assertEquals(nimi, pelaaja.getNimi());
	}
	
	@Test
	void valinta() {
		assertTrue(Arrays.asList(Valinnat.values()).contains(new Pelaaja(null).pelaajanValinta()));
	}
}
