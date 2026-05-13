package week3.role;

import week3.policy.Policy;
import week3.policy.StaffPolicy;

public class Staff extends Role{



    private String position; // 직책

    public Staff(String name, String major, int cd, String part, String position) {
        super(name, major, cd, part);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public Policy getPolicy() {
        return new StaffPolicy();
    }

    @Override
    public String getDetailInfo() {
        return "🦸 역할: 운영진\n"
                + "👤 이름: " + getName()
                + " | 🎓 전공: " + getMajor()
                + " | 📌 기수: " + getCd()
                + " | 💻 파트: " + getPart() + "\n"
                + "⭐ 직책: " + position;
    }
}