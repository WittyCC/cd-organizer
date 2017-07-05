import org.junit.*;
import static org.junit.Assert.*;

public class ArtistTest {

  @Test
  public void artist_instantiatesCorrectly_true() {
    Artist testArtist = new Artist("Pink");
    assertEquals(true, testArtist instanceof Artist);
  }

  @Test
  public void all_returnsAllInstancesOfArtist_true() {
    Artist firstArtist = new Artist("Pink");
    Artist secondArtist = new Artist("Datsik");
    assertEquals(true, Artist.all().contains(firstArtist));
    assertEquals(true, Artist.all().contains(secondArtist));
  }

  @Test
  public void clear_emptiesAllArtistsFromList_0() {
    Artist testArtist = new Artist("Pink");
    Artist.clear();
    assertEquals(Artist.all().size(), 0);
  }

  @Test
  public void getId_artistsInstantiateWithAnId_1() {
    Artist testArtist = new Artist("Pink");
    assertEquals(1, testArtist.getId());
  }

  @Test
  public void find_returnsArtistWithSameId_secondArtist() {
    Artist.clear();
    Artist firstArtist = new Artist("Pink");
    Artist secondArtist = new Artist("Datsik");
    assertEquals(Artist.find(secondArtist.getId()), secondArtist);
  }

}
