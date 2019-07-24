package home.tong.http.client;

import java.io.Serializable;

public class Tag implements Serializable {
    private String tag;

    public Tag() {
        super();
    }

    public Tag(String tag) {
        super();
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
