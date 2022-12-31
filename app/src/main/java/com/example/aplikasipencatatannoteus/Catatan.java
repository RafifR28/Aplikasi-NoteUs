package com.example.aplikasipencatatannoteus;

public class Catatan {
    public String uid;
    public String userId;
    public String email;
    public String catatan;

    public Catatan() {

    }

    public Catatan(String userId, String email, String catatan) {
        this.userId = userId;
        this.email = email;
        this.catatan = catatan;
    }
}
