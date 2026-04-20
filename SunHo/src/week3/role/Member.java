package week3.role;

import week3.policy.Policy;

abstract public class Member implements Policy {
    private String name;
    private String major;
    private int cohort;
    private String part;

    public Member(String name, String major, int cohort, String part) {
        this.name = name;
        this.major = major;
        this.cohort = cohort;
        this.part = part;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getCohort() {
        return cohort;
    }

    public String getPart() {
        return part;
    }

    public abstract Policy getPolicy();

    public abstract String getDetails();

    public boolean isSubmittable(){
        return getPolicy().isSubmittable();
    }
}
