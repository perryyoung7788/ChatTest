package com.example.chattest;


public class Msg {
    static final int TYPE_RECEIVED = 0;
    static final int TYPE_SEND = 1;
    private int type;
    private String content;
    private String image;

    public Msg (String content, int type){
        this.content = content;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
