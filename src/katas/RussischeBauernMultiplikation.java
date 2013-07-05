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
    assertEquals(1, multipliziereNachRussischerBauernart(1, 1));
    assertEquals(357, multipliziereNachRussischerBauernart(17, 21));
    assertEquals(513, multipliziereNachRussischerBauernart(27, 19));
  }

  public int multipliziereNachRussischerBauernart(int x, int y) {

    final HashMap<Integer, Integer> gemerkteZahlen = new HashMap<Integer, Integer>();
    gemerkteZahlen.put(x, y);

    while (x >= 2) {
      x = halbiere(x);
      y = y * 2;
      gemerkteZahlen.put(x, y);
    }
    return ermittleErgebnis(gemerkteZahlen);
  }

  private int halbiere(final int x) {
    final int zahl = (x % 2 != 0) ? x - 1 : x;
    return zahl / 2;
  }

  private int ermittleErgebnis(final HashMap<Integer, Integer> gemerkteZahlen) {
    int ergebnis = 0;
    for (int key : gemerkteZahlen.keySet()) {
      ergebnis = (key % 2 != 0) ? ergebnis += gemerkteZahlen.get(key) : ergebnis;
    }
    return ergebnis;
  }

}
