package katas;

/**
 * Implementiere eine Funktion zum Übersetzen von Mail Followup Email Adressen in Datums und Uhrzeitangaben.
 * (https://app.box.com/s/lw9gmh055nyverdiuk59)
 */

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class MailFollowupTest {

	@Test
	public void oneHour() {
		Calendar now = Calendar.getInstance();
		now.set(2015, Calendar.JANUARY, 1, 12, 0, 0);
		Calendar followUp = followupZeitpunkt(now, "1hour");
		assertEquals(13, followUp.get(Calendar.HOUR_OF_DAY));
	}

	private Calendar followupZeitpunkt(final Calendar now, final String string) {
		checkHour(now, string);
		return now;
	}

	/*
	 * Idee:
	 * Implementiere eine String-Erkennung für Minuten, Stunden, Tage, Monate, Jahre ...
	 * Laufe die String-Erkennungen alle nacheinander durch und führe je nach Zeit-Angabe die entsprechende Operation durch
	 * Es werden dabei wohl einige Methoden entstehen, die alle die gleiche Signatur haben und im Grunde das gleiche tun ...
	 */

	private Calendar checkHour(final Calendar now, final String stringToCheck) {
		now.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY) + 1);
		return now;
	}

}
