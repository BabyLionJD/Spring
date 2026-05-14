package week5.step1.role;

import week5.step1.policy.LionPolicy;
import week5.step1.policy.Policy;

public class Lion extends Role {

    private int id;

    public Lion(String name, String major, int cd, String part, int id) {
        super(name, major, cd, part);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public Policy getPolicy() {
        return new LionPolicy();
    }

    @Override
    public String getDetailInfo() {
        return "🦁 역할: 아기사자\n"
                + "👤 이름: " + getName()
                + " | 🎓 전공: " + getMajor()
                + " | 📌 기수: " + getCd()
                + " | 💻 파트: " + getPart() + "\n"
                + "🆔 학번: " + id;
    }
}