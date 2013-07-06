package katas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RussischeBauernMultiplikationTest {

  private RussischeBauernMultiplikation multiplikation;

  @Before
  public void setup(){
    this.multiplikation = new RussischeBauernMultiplikation();
  }

  @Test
  public void testMultiplikation() {
    assertEquals(1, multiplikation.multipliziereNachRussischerBauernart(1, 1));
    assertEquals(357, multiplikation.multipliziereNachRussischerBauernart(17, 21));
    assertEquals(513, multiplikation.multipliziereNachRussischerBauernart(27, 19));
    assertEquals(25704, multiplikation.multipliziereNachRussischerBauernart(714, 36));
  }

}
