package katas;

import static org.junit.Assert.*;

import java.util.HashMap;
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
    assertEquals(357, multipliziere(17, 21));
	}

  public int multipliziere(int x, int y) {

    final HashMap<Integer, Integer> gemerkteZahlen = new HashMap<Integer, Integer>();
    int ergebnis = 0;
    gemerkteZahlen.put(x, y);

    if (x == 1 && y == 1) {
      return x * y;
    }
    else {
      while (x >= 2) {
        if (x % 2 != 0) {
          x = (x - 1) / 2; // abrunden bei Rest 1
        }
        else {
          x = x / 2;
        }
        y = y * 2;
        gemerkteZahlen.put(x, y);
      }
      for (int key : gemerkteZahlen.keySet()) {
        System.out.println(key + ", " + gemerkteZahlen.get(key));
        if (key % 2 != 1) {
          continue;
        }
        ergebnis += gemerkteZahlen.get(key);
      }
      return ergebnis;
    }
  }

}
