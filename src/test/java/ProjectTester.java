import static org.junit.Assert.*;

import org.junit.Test;




import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
  public void isWellSorted_ordered_descending_true() {
    assertFalse(testfall.isWellSorted(new String[]{"D", "C", "B", "A"}));
  }
}
    