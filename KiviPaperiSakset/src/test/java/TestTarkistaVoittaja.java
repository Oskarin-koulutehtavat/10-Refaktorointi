import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import kivipaperisakset.Valinnat;
import kivipaperisakset.Pelaaja;
import kivipaperisakset.Pelinohjaaja;

class TestTarkistaVoittaja {
	
	@Mock
	Pelaaja pelaaja1;
	
	@Mock
	Pelaaja pelaaja2;
	
	Method getTarkistaVoittajaMethod() throws NoSuchMethodException {
		Method tarkistaVoittaja = Pelinohjaaja.class.getDeclaredMethod("tarkistaVoittaja", Pelaaja.class, Pelaaja.class);
		tarkistaVoittaja.setAccessible(true);
		return tarkistaVoittaja;
	}

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	// Palaaja 1 voittaa
	@Test
	void TestKiviSakset() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Mockito.when(pelaaja1.pelaajanValinta()).thenReturn(Valinnat.KIVI);
		Mockito.when(pelaaja2.pelaajanValinta()).thenReturn(Valinnat.SAKSET);
		
		assertEquals(pelaaja1, getTarkistaVoittajaMethod().invoke(null, pelaaja1, pelaaja2));
		
		Mockito.verify(pelaaja1).pelaajanValinta();
		Mockito.verify(pelaaja2).pelaajanValinta();
	}
	
	@Test
	void TestPaperiKivi() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Mockito.when(pelaaja1.pelaajanValinta()).thenReturn(Valinnat.PAPERI);
		Mockito.when(pelaaja2.pelaajanValinta()).thenReturn(Valinnat.KIVI);
		
		assertEquals(pelaaja1, getTarkistaVoittajaMethod().invoke(null, pelaaja1, pelaaja2));
		
		Mockito.verify(pelaaja1).pelaajanValinta();
		Mockito.verify(pelaaja2).pelaajanValinta();
	}
	
	@Test
	void TestSaksetPaperi() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Mockito.when(pelaaja1.pelaajanValinta()).thenReturn(Valinnat.SAKSET);
		Mockito.when(pelaaja2.pelaajanValinta()).thenReturn(Valinnat.PAPERI);
		
		assertEquals(pelaaja1, getTarkistaVoittajaMethod().invoke(null, pelaaja1, pelaaja2));
		
		Mockito.verify(pelaaja1).pelaajanValinta();
		Mockito.verify(pelaaja2).pelaajanValinta();
	}
	
	// Pelaaja 2 voittaa
	@Test
	void TestKiviPaperi() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Mockito.when(pelaaja1.pelaajanValinta()).thenReturn(Valinnat.KIVI);
		Mockito.when(pelaaja2.pelaajanValinta()).thenReturn(Valinnat.PAPERI);
		
		assertEquals(pelaaja2, getTarkistaVoittajaMethod().invoke(null, pelaaja1, pelaaja2));
		
		Mockito.verify(pelaaja1).pelaajanValinta();
		Mockito.verify(pelaaja2).pelaajanValinta();
	}
	
	@Test
	void TestPaperiSakset() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Mockito.when(pelaaja1.pelaajanValinta()).thenReturn(Valinnat.PAPERI);
		Mockito.when(pelaaja2.pelaajanValinta()).thenReturn(Valinnat.SAKSET);
		
		assertEquals(pelaaja2, getTarkistaVoittajaMethod().invoke(null, pelaaja1, pelaaja2));
		
		Mockito.verify(pelaaja1).pelaajanValinta();
		Mockito.verify(pelaaja2).pelaajanValinta();
	}
	
	@Test
	void TestSaksetKivi() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Mockito.when(pelaaja1.pelaajanValinta()).thenReturn(Valinnat.SAKSET);
		Mockito.when(pelaaja2.pelaajanValinta()).thenReturn(Valinnat.KIVI);
		
		assertEquals(pelaaja2, getTarkistaVoittajaMethod().invoke(null, pelaaja1, pelaaja2));
		
		Mockito.verify(pelaaja1).pelaajanValinta();
		Mockito.verify(pelaaja2).pelaajanValinta();
	}
	
	// Tasapeli
	@Test
	void TestKiviKivi() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Mockito.when(pelaaja1.pelaajanValinta()).thenReturn(Valinnat.KIVI);
		Mockito.when(pelaaja2.pelaajanValinta()).thenReturn(Valinnat.KIVI);
		
		assertEquals(null, getTarkistaVoittajaMethod().invoke(null, pelaaja1, pelaaja2));
		
		Mockito.verify(pelaaja1).pelaajanValinta();
		Mockito.verify(pelaaja2).pelaajanValinta();
	}
	
	@Test
	void TestPaperiPaperi() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Mockito.when(pelaaja1.pelaajanValinta()).thenReturn(Valinnat.PAPERI);
		Mockito.when(pelaaja2.pelaajanValinta()).thenReturn(Valinnat.PAPERI);
		
		assertEquals(null, getTarkistaVoittajaMethod().invoke(null, pelaaja1, pelaaja2));
		
		Mockito.verify(pelaaja1).pelaajanValinta();
		Mockito.verify(pelaaja2).pelaajanValinta();
	}
	
	@Test
	void TestSaksetSakset() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Mockito.when(pelaaja1.pelaajanValinta()).thenReturn(Valinnat.SAKSET);
		Mockito.when(pelaaja2.pelaajanValinta()).thenReturn(Valinnat.SAKSET);
		
		assertEquals(null, getTarkistaVoittajaMethod().invoke(null, pelaaja1, pelaaja2));
		
		Mockito.verify(pelaaja1).pelaajanValinta();
		Mockito.verify(pelaaja2).pelaajanValinta();
	}
	
}
