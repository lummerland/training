package katas;

/*
 Entwickle eine Funktion, die erkennt, ob eine Zahl „fröhlich“ ist oder nicht.
 Eine [Fröhliche Zahl] ist eine Zahl, bei der die Summe der Quadrate ihrer Ziffern „auf die Dauer“ 1 ergibt.

 Beispiel:
 19 -> 1^2 + 9^2 = 82
 -> 8^2 + 2^2 = 68
 -> 6^2 + 8^2 = 100
 -> 1^2 + 0^2 + 0^2 = 1
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FroehlicheZahlenTest {

  @Test
  public void testIstFroehlicheZahl() {
    assertEquals(true, istFroehlicheZahl(1));
  }

  // Integrationstest
  public boolean istFroehlicheZahl(int zahl) {
    return (zahl == 1) ? true : false;
    // quadriere jede Ziffer
    // summiere die Quadrate
    // entscheide, ob die Zahl wieder zerlegt werden kann oder
    // entscheide, ob die Summe das Kriterium fröhliche Zahl erfüllt
  }

  @Test
  public void zerlegeZahlTest() {
    assertEquals(new Integer[] { 1, 1 }, zerlegeZahl(11));
  }

    // zerlege die Zahl in Ziffern
  public Integer[] zerlegeZahl(int zahl) {
    return new Integer[] { 1, 1 };
  }

}
