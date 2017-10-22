import static org.junit.Assert.*;

import org.junit.Test;




import org.junit.Before;

public class ProjectTester {
  Project testfall;

  @Before
  public void setUp(){
    testfall = new Project(new String[][]{{"A", "B"}, {"B", "C"}, {"C", "D"}});
  }

  @Test
  public void isWellSorted_ordered_ascending_true() {
    assertTrue(testfall.isWellSorted(new String[]{"A", "B", "C", "D"}));
  }

  @Test
  public void isWellSorted_ordered_descending_false() {
    assertFalse(testfall.isWellSorted(new String[]{"D", "C", "B", "A"}));
  }

  @Test
  public void isWellSorted_wrongOrder_false() {
    assertFalse(testfall.isWellSorted(new String[]{"C", "A", "D", "B"}));
  }

  @Test
  public void isWellSorted_wrongOrderAndMissingStep_false() {
    assertFalse(testfall.isWellSorted(new String[]{"D", "C", "A"}));
  }

  @Test
  public void isWellSorted_orderedAndMissingStep_false() {
    assertFalse(testfall.isWellSorted(new String[]{"A", "B", "C"}));
  }

  @Test
  public void isWellSorted_orderedAscendingWrongStep_false() {
    assertFalse(testfall.isWellSorted(new String[]{"A", "B", "C", "D", "E"}));
  }

  @Test
  public void isWellSorted_orderedAscendingWrongAndMissingStep_false() {
	    assertFalse(testfall.isWellSorted(new String[]{"A", "E", "C", "D" }));
  }

  @Test
  public void isWellSorted_notEnoughStepsAndWrongStep_false() {
	    assertFalse(testfall.isWellSorted(new String[]{"E", "C"}));
  }

  @Test
  public void isWellSorted_wrongStepsAndWrongFormat_false() {
	    assertFalse(testfall.isWellSorted(new String[]{"CompletelyWrong"}));
  }

}
    