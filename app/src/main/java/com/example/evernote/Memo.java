package com.example.evernote;

public class Memo {

    int seq;
    String title;//제목
    String text;//본문

    public Memo(int seq, String title, String text) {
        this.seq = seq;
        this.title = title;
        this.text = text;
    }

    //단축키 alt + insert
    //생성자
    public Memo(String title, String text) {
        this.title = title;
        this.text = text;
    }


    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
