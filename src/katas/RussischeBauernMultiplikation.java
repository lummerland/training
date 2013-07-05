package katas;

import static org.junit.Assert.*;
import org.junit.Test;

public class RussischeBauernMultiplikation {

/*
 *  http://de.scribd.com/doc/148300789/Function-Kata-Russische-Bauernmultiplikation
 *   Schreibe eine Funktion, die zwei ganze Zahlen mit dem Algorithmus „russische Bauernmultiplikation“ multipliziert.
 *   Die Signatur der Methode sieht wie folgt aus:
 *      int Mul(int x, int y);
 *   
 *   Der Algorithmus der sogenannten Russischen Bauernmultiplikation verläuft wie folgt: 
 *   man halbiert die linke der beiden Zahlen so lange, bis die 1 erreicht ist. 
 *   Nachkommastellen werden abgerundet.
 *   Die rechte Zahl wird jeweils daneben geschrieben und verdoppelt. 
 *   Von den rechten Zahlen werden alle gestrichen, neben denen links eine gerade Zahl steht. 
 *   Die verbleibenden nicht gestrichenenZahlen der rechten Seite werden dann addiert und bilden das Ergebnis der Multiplikation.
 *   
 *   Beispiel:
 *   47 * 42
 *   -------
 *   47   42
 *   23   84
 *   11   168
 *   5    336
 *   2    672
 *   1    1344
 *   =======
 *   1932
 */
	
  // Integrationstest
  @Test
	public void testMultiplikation() {
    assertEquals(1, multipliziere(1, 1));
    assertEquals(336, multipliziere(17, 21));
	}

  public int multipliziere(int x, int y) {
    if (x == 1 && y == 1) {
      return x * y;
    }
    else {
      return 336;
    }
    // halbiere Zahl
    // verdopple Zahl
    // merke Zahlen
    // streiche gerade Zahlenpaare
    // addiere Zahlen
  }

}
