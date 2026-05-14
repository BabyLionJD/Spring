package week4.role;

import week4.policy.Policy;

public abstract class Role {

    private String name;   // 이름
    private String major;  // 전공
    private int cd;        // 기수
    private String part;   // 백엔드 / 프론트엔드 파트 구분

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

    // 역할별 정책 객체를 자식 클래스가 반환
    public abstract Policy getPolicy();

    // 역할별 상세 정보 출력
    public abstract String getDetailInfo();

    // 과제 제출 가능 여부 판단
    public boolean submit() {
        return getPolicy().checkSub();
    }
}