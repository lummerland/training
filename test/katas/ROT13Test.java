package katas;

/*
 *  Schreibe eine Funktion, die einen Text mit dem Verfahren [ROT-13] verschlüsselt.
 *  Bei ROT-13 wird jeder Buchstabe des zu verschlüsselnden Textes durch den ersetzt, 
 *  der 13 Stellen weiter hinten im Alphabet liegt. Sollte dabei über das Alphabetende 
 *  hinausgegriffen werden, gehtes am Anfang weiter. 
 *  Aus „e“ wird „R“ und aus „W“ wird „J“. 
 *  Kleinbuchstaben werden in Großbuchstaben verwandelt.
 *  Umlaute müssen vor Verschlüsselung durch Buchstabenkombinationen ersetzt werden: 
 *  „Ö“ =„OE“, „Ä“ = „AE“, „Ü“ = „UE“, „ß“ = „SS“.
 *  Zeichen die keine Buchstaben sind, werden nicht verschlüsselt.
 */

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ROT13Test {

  @Test
  public void verschluesselTest() {
    assertEquals("N", verschluessel("a"));
    assertEquals("NO", verschluessel("ab"));
    assertEquals("IREFPUYUEFFRYA", verschluessel("Verschlüsseln"));
  }

  public String verschluessel(String text) {

    final List<String> original = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
        "w", "x", "y", "z", "ä", "ö", "ü", "ß");
    final List<String> ersatz = Arrays.asList("n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "a", "b", "c", "d", "e", "f", "g", "h", "i",
        "j", "k", "l", "m", "ae", "oe", "ue", "ss");

    String ergebnis = text;
    final Iterator<String> iterator = original.iterator();
    while (iterator.hasNext()) {
      String buchstabe = iterator.next();
      System.out.println("Buchstabe: " + buchstabe);
      System.out.println("Ergebnis 1: " + ergebnis);
      ergebnis = text.replace(buchstabe, ersatz.get(original.indexOf(buchstabe)));
      System.out.println("Ergebnis 2: " + ergebnis);
      text = ergebnis;
    }
    return ergebnis.toUpperCase();
  }
}
