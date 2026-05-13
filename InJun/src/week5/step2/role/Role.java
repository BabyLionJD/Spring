package week5.step2.role;

import week5.step2.policy.Policy;

public abstract class Role {

    private String name;
    private String major;
    private int cd;
    private String part;

    public Role(String name, String major, int cd, String part) {
        this.name = name;
        this.major = major;
        this.cd = cd;
        this.part = part;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getCd() {
        return cd;
    }

    public String getPart() {
        return part;
    }

    public abstract Policy getPolicy();

    public abstract String getDetailInfo();

    public boolean submit() {
        return getPolicy().checkSub();
    }
}