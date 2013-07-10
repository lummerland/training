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

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class FroehlicheZahlenTest {

  @Test
  public void testIstFroehlicheZahl() {
    assertEquals(true, istFroehlicheZahl(1));
    assertEquals(false, istFroehlicheZahl(18));
    assertEquals(true, istFroehlicheZahl(19));
  }

  // >>> Integrationstest
  public boolean istFroehlicheZahl(int zahl) {
    int moeglicheFroehlicheZahl = zahl;
    while (istZahlZerlegbar(moeglicheFroehlicheZahl)) {
      final List<Integer> ziffern = zerlegeZahl(moeglicheFroehlicheZahl);
      moeglicheFroehlicheZahl = quadriereZiffernUndBildeSumme(ziffern);
    }
    return (moeglicheFroehlicheZahl == 1) ? true : false;
  }

  @Test
  public void zerlegeZahlTest() {
    assertEquals(new ArrayList<Integer>(Arrays.asList(1, 1)), zerlegeZahl(11));
    assertEquals(new ArrayList<Integer>(Arrays.asList(1, 2)), zerlegeZahl(12));
    assertEquals(new ArrayList<Integer>(Arrays.asList(1, 2, 6, 8)), zerlegeZahl(1268));
  }

  public List<Integer> zerlegeZahl(int zahl) {
    final List<Integer> ziffern = new ArrayList<Integer>();
    while (zahl > 0) {
      ziffern.add(zahl % 10);
      zahl = (zahl / 10);
    }
    Collections.reverse(ziffern);
    return ziffern;
  }

  @Test
  public void quadriereZiffernUndBildeSummeTest() {
    assertEquals(5, quadriereZiffernUndBildeSumme(Arrays.asList(1, 2)));
    assertEquals(169, quadriereZiffernUndBildeSumme(Arrays.asList(5, 12)));
    assertEquals(257, quadriereZiffernUndBildeSumme(Arrays.asList(3, 2, 10, 12)));
  }

  public int quadriereZiffernUndBildeSumme(List<Integer> ziffern) {
    final int menge = ziffern.size();
    int summe = 0;
    for (int i = 0; i < menge; i++) {
      summe += (ziffern.get(i) * ziffern.get(i));
    }
    return summe;
  }

  @Test
  public void istZahlZerlegbarTest() {
    assertEquals(true, istZahlZerlegbar(11));
    assertEquals(false, istZahlZerlegbar(1));
    assertEquals(true, istZahlZerlegbar(988989));
  }

  public boolean istZahlZerlegbar(int zahl) {
    return String.valueOf(zahl).length() > 1;
  }

}
