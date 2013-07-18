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

import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

public class ROT13Test {

  @Test
  public void verschluesselTest() {
    assertEquals("N", verschluessel("a"));
    assertEquals("NO", verschluessel("ab"));
    assertEquals("NOP", verschluessel("abc"));
    assertEquals("IREFPUYUEFFRYHAT", verschluessel("Verschlüsselung"));
    assertEquals("QNF VFG RVA GRKG", verschluessel("Das ist ein Text"));
  }

  public String verschluessel(String text) {

    final HashMap<String, String> verschluesselung = new HashMap<String, String>();
    verschluesselung.put("a", "N");
    verschluesselung.put("b", "O");
    verschluesselung.put("c", "P");
    verschluesselung.put("d", "Q");
    verschluesselung.put("e", "R");
    verschluesselung.put("f", "S");
    verschluesselung.put("g", "T");
    verschluesselung.put("h", "U");
    verschluesselung.put("i", "V");
    verschluesselung.put("j", "W");
    verschluesselung.put("k", "X");
    verschluesselung.put("l", "Y");
    verschluesselung.put("m", "Z");
    verschluesselung.put("n", "A");
    verschluesselung.put("o", "B");
    verschluesselung.put("p", "C");
    verschluesselung.put("q", "D");
    verschluesselung.put("r", "E");
    verschluesselung.put("s", "F");
    verschluesselung.put("t", "G");
    verschluesselung.put("u", "H");
    verschluesselung.put("v", "I");
    verschluesselung.put("w", "J");
    verschluesselung.put("x", "K");
    verschluesselung.put("y", "L");
    verschluesselung.put("z", "M");
    verschluesselung.put("ä", "AE");
    verschluesselung.put("ö", "OE");
    verschluesselung.put("ü", "UE");
    verschluesselung.put("ß", "SS");

    char[] buchstaben = text.toCharArray();
    StringBuffer ergebnis = new StringBuffer();
    Set<String> keys = verschluesselung.keySet();

    for (char c : buchstaben) {
      if (keys.contains(Character.toString(c).toLowerCase())) {
        ergebnis.append(verschluesselung.get(Character.toString(c).toLowerCase()));
      }
      else {
        ergebnis.append(c);
      }
    }
    return ergebnis.toString();
  }
}
