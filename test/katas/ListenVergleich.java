package katas;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListenVergleich {

	@Test
	public void onlyWildcards() {
		assertEquals(true, vergleicheListen(Arrays.asList("none", "none", "none"), Arrays.asList("a","b","c")));
	}

	@Test
	public void equalLists() {
		assertEquals(true, vergleicheListen(Arrays.asList("a", "b", "c"), Arrays.asList("a","b","c")));
	}

	@Test
	public void oneWildcard() {
		assertEquals(true, vergleicheListen(Arrays.asList("a", "b", "none"), Arrays.asList("a","b","c")));
		assertEquals(true, vergleicheListen(Arrays.asList("none", "b", "c"), Arrays.asList("a","b","c")));
		assertEquals(true, vergleicheListen(Arrays.asList("a", "none", "c"), Arrays.asList("a","b","c")));
	}

	@Test
	public void twoWildcards() {
		assertEquals(true, vergleicheListen(Arrays.asList("none", "none", "c"), Arrays.asList("a","b","c")));
		assertEquals(true, vergleicheListen(Arrays.asList("none", "b", "none"), Arrays.asList("a","b","c")));
		assertEquals(true, vergleicheListen(Arrays.asList("none", "none", "c"), Arrays.asList("a","b","c")));
	}

	@Test
	public void noFit() {
		assertEquals(false, vergleicheListen(Arrays.asList("c", "b", "c"), Arrays.asList("a","b","c")));
		assertEquals(false, vergleicheListen(Arrays.asList("c", "b", "x"), Arrays.asList("a","b","c")));
	}

	public boolean vergleicheListen(final List<String> liste1, final List<String> liste2) {
		boolean result = true;
		for(int i=0; i < liste1.size(); i++) {
			if(!liste1.get(i).equals("none") && !liste1.get(i).equals(liste2.get(i))) {
				result = false;
			}
		}
		return result;
	}
}
