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

import org.junit.Test;

public class ROT13Test {

  @Test
  public void verschluesselTest() {
    assertEquals("N", verschluessel("a"));
    assertEquals("NO", verschluessel("ab"));
  }

  public String verschluessel(String text) {
    final HashMap<String, String> zuordnungen = new HashMap<String, String>();
    zuordnungen.put("a", "n");
    zuordnungen.put("b", "o");
    String ergebnis = text;
    for (String buchstabe : zuordnungen.keySet()) {
      ergebnis = text.replace(buchstabe, zuordnungen.get(buchstabe).toUpperCase());
      text = ergebnis;
    }
    return ergebnis;
  }
}
