package katas;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Test;

//    x
//   xxx
//  xxxxx
// xxxxxxx
//    x

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
