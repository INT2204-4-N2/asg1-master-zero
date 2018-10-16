package sample;

public class Word {
    String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    String word_target;
    String word_plain;

    public String getWord_plain() {
        return word_plain;
    }

    public void setWord_plain(String word_plain) {
        this.word_plain = word_plain;
    }

    public void word(String a,String b)
    {
       this.word_target=a;
        this.word_plain=b;
    }


}
