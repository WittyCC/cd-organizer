import org.junit.*;
import static org.junit.Assert.*;

public class CDTest {

@Test
  public void cd_instantiatesCorrectly_true() {
    CD testCD = new CD("True about love");
    assertEquals(true, testCD instanceof CD);
  }
  @Test
    public void all_returnsAllInstancesOfCD_true() {
      CD firstCD = new CD("True about love");
      CD secondCD = new CD("Nuke'Em");
      assertEquals(true, CD.all().contains(firstCD));
      assertEquals(true, CD.all().contains(secondCD));
    }
    @Test
    public void clear_emptiesAllCDsFromList_0() {
      CD testCD = new CD("True about love");
      CD.clear();
      assertEquals(CD.all().size(), 0);
    }

    @Test
    public void getId_CDsInstantiateWithAnId_1() {
      CD testCD = new CD("True about love");
      assertEquals(1, testCD.getId());
    }

    @Test
    public void find_returnsCDWithSameId_secondCD() {
      CD.clear();
      CD firstCD = new CD("True about love");
      CD secondCD = new CD("Nuke'Em");
      assertEquals(CD.find(secondCD.getId()), secondCD);
    }

}
