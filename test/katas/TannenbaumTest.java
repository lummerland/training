package katas;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Test;

//     x
//    xxx
//   xxxxx
//  xxxxxxx
// xxxxxxxxx
//     x

// diverse Infos:
// die unterste (längste) Reihe hat (Höhe * 2) - 1 x-Zeichen
// jede Reihe hat zwei x-Zeichen weniger als die darunter liegende
// die Menge der x-Zeichen in einer Reihe ist immer ungerade
// die Leerzeichen werden durch Spaces erzeugt
// jede Reihe hat rechts und links die gleiche Menge an Leerzeichen
// jede Reihe ist durch einen Umbruch von der nächsten getrennt
// die Summe aller Zeichen ist in jeder Reihe gleich und entspricht der Zeichenmenge der untersten Reihe
// ganz unten kommt immer ein Fuß, der zählt aber nicht zur Höhe und ist eine Kopie der Spitze

// Ablauf:
// die erste Reihe besteht aus 	(Höhe - 1) * Leerzeichen . ( ( (Höhe * 2) - 1 ) - 2 * (Höhe - 1) ) * x . (Höhe - 1) * Leerzeichen
// die zweite Reihe besteht aus (Höhe - 2) * Leerzeichen . ( ( (Höhe * 2) - 1 ) - 2 * (Höhe - 2) ) * x . (Höhe - 2) * Leerzeichen
// die n-te Reihe besteht aus 	(Höhe - n) * Leerzeichen . ( ( (Höhe * 2) - 1 ) - 2 * (Höhe - n) ) * x . (Höhe - n) * Leerzeichen
// wenn Fertig, dann der Fuß		(Höhe - 1) * Leerzeichen . x . (Höhe - 1) * Leerzeichen

// Funktionalitäten:
// 1. ermittle die zu setzenden x für die Reihe
// 2. ermittle die zu setzenden Leerzeichen für die Reihe
// 3. setze die Reihe zusammen
// 4. nächste Reihe
// 5. Fuß setzen

public class TannenbaumTest {

	@Test
	public void zeichneTest() {
		// Höhe 1 bedeutet, dass nichts getan wird
		assertThat(zeichneTannenbaum(1), Is.is("x"));
	}

	public String zeichneTannenbaum(final int hoehe) {
		return "x";
	}

	@Test
	public void ermittleZuSetzendeZeichenTest() {
		assertThat(ermittleZuSetzendeZeichen(1,5), Is.is(1));
		assertThat(ermittleZuSetzendeZeichen(2,5), Is.is(3));
		assertThat(ermittleZuSetzendeZeichen(5,5), Is.is(9));
	}

	private Integer ermittleZuSetzendeZeichen(final int reihe, final int gesamt) {
		return ( ( (gesamt * 2) - 1 ) - 2 * (gesamt - reihe) );
	}

	@Test
	public void ermittleZuSetzendeLeerzeichenTest() {
		assertThat(ermittleZuSetzendeLeerzeichen(1,5), Is.is(8));
		assertThat(ermittleZuSetzendeLeerzeichen(4,5), Is.is(2));
		assertThat(ermittleZuSetzendeLeerzeichen(5,5), Is.is(0));
	}

	private Integer ermittleZuSetzendeLeerzeichen(final int reihe, final int gesamt) {
		return 2 * (gesamt- reihe);
	}

	@Test
	public void setzeReiheZusammenTest() {
		assertThat(setzeReiheZusammen(1,5), Is.is("    x    "));
		assertThat(setzeReiheZusammen(2,5), Is.is("   xxx   "));
		assertThat(setzeReiheZusammen(5,5), Is.is("xxxxxxxxx"));
	}

	private String setzeReiheZusammen(final int reihe, final int gesamt) {
		final StringBuffer ergebnis = new StringBuffer();
		for (int i = 0; i < ermittleZuSetzendeLeerzeichen(reihe, gesamt); i++) {
			ergebnis.append(" ");
		}
		for (int i = 0; i < ermittleZuSetzendeZeichen(reihe, gesamt); i++) {
			ergebnis.insert(ermittleZuSetzendeLeerzeichen(reihe, gesamt)/2, "x");
		}
		return ergebnis.toString();
	}

}
