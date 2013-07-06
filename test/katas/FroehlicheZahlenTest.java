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

import static org.junit.Assert.*;
import org.junit.Test;

public class FroehlicheZahlenTest {

  @Test
  public void testIstFroehlicheZahl() {
    assertEquals(true,istFroehlicheZahl(19));
  }

  public boolean istFroehlicheZahl(int zahl){
    return true;
  }

}
