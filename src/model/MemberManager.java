package model;

import java.util.ArrayList;

public class MemberManager {
    private static MemberManager instance;
    private Member member;
    private String password;

    private MemberManager(){}

    public static MemberManager getInstance() {
        if (instance == null) {
            instance = new MemberManager();
        }
        return instance;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
