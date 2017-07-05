import java.util.List;
import java.util.ArrayList;

public class CD {
  private String mAlbumName;
  private String mMusicType;
  private static List<CD> instances = new ArrayList<CD>();
  private int mId;

  public CD (String name, String musicType) {
    mAlbumName = name;
    mMusicType = musicType;
    instances.add(this);
    mId = instances.size();
  }

  public String getAlbumName() {
    return mAlbumName;
  }

  public String getMusicType() {
    return mMusicType;
  }

  public static List<CD> all() {
    return instances;
  }
  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }
  public static CD find(int id) {
    return instances.get(id - 1);
  }

}
