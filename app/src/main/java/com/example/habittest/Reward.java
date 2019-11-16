package com.example.habittest;

/**
 * Created by admin on 2019/10/6.
 */

public class Reward {
    public String content;
    public String pic;

    public Reward(String pic,String content) {
        this.content = content;
        this.pic = pic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
