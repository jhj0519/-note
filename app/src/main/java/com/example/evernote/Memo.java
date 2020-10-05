package com.example.evernote;

public class Memo {
    String title;//제목
    String text;//본문
    int isdone;//상태표시

    //단축키 alt + insert
    //생성자
    public Memo(String title, String text, int isdone) {
        this.title = title;
        this.text = text;
        this.isdone = isdone;
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

    public int getIndone() {
        return isdone;
    }

    public void setTF(int indone) {
        this.isdone = indone;
    }
}
