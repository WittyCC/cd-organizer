import java.util.List;
import java.util.ArrayList;

public class Artist {
  private String mArtistName;
  private static List<Artist> instances = new ArrayList<Artist>();
  private int mId;
  private List<CD> mCDs;

  public Artist (String name) {
    mArtistName = name;
    instances.add(this);
    mId = instances.size();
    mCDs = new ArrayList<CD>();
  }

  public String getArtistName() {
    return mArtistName;
  }

  public static List<Artist> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Artist find(int id) {
    return instances.get(id - 1);
  }

  public List<CD> getCDs() {
    return mCDs;
  }

  public void addCD(CD cd) {
    mCDs.add(cd);
  }
}
