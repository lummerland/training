package katas;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Test;

//    x
//   xxx
//  xxxxx
// xxxxxxx
//    x

// diverse Infos:
// jede Reihe hat zwei x-Zeichen mehr als die darüber liegende
// die Menge der x-Zeichen in einer Reihe ist immer ungerade
// die Leerzeichen werden durch Spaces erzeugt
// jede Reihe hat rechts und links die gleiche Menge an Leerzeichen
// jede Reihe ist durch einen Umbruch von der nächsten getrennt
// die Summe aller Zeichen ist in jeder Reihe gleich und entspricht der Zeichenmenge der untersten Reihe
// ganz unten kommt immer ein Fuß, der zählt aber nicht zur Höhe und ist eine Kopie der Spitze

// Ablauf:
// die erste Reihe besteht aus 	(Höhe - 1) * Leerzeichen . x . (Höhe - 1) * Leerzeichen
// die zweite Reihe besteht aus (Höhe - 2) * Leerzeichen . x . (Höhe - 2) * Leerzeichen
// die n-te Reihe besteht aus 	(Höhe - n) * Leerzeichen . x . (Höhe - n) * Leerzeichen
// wenn Fertig, dann der Fuß		(Höhe - 1) * Leerzeichen . x . (Höhe - 1) * Leerzeichen

public class TannenbaumTest {

	@Test
	public void zeichneTest() {
		// Höhe 1 bedeutet, dass nichts getan wird
		assertThat(zeichneTannenbaum(1), Is.is("x"));
	}

	public String zeichneTannenbaum(final int hoehe) {
		return "x";
	}

}
