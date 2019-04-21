package to.msn.wings.tokyogirlshackason;

import java.io.Serializable;


public class MyClothes implements Serializable {

    String id;
    String category;
    String uri;

    public MyClothes() {}

    public MyClothes(String _id,String _category, String _uri) {
        id = _id;
        category = _category;
        uri = _uri;
    }

    public String toString() {
        return id + ":" + category + " : " + uri;

    }
}
