package enit.bank;

public class Review {
    private int note;
    private String rev;


    public Review(int note, String rev){
        this.note= note;
        this.rev=rev;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note=note;
    }

    public String getReview() {
        return rev;
    }

    public void setReview(String rev) {
        this.rev=rev;
    }
}