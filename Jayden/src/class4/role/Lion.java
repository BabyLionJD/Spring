package class4.role;

import class4.policy.LionSubmissionPolicy;
import class4.policy.SubmissionPolicy;

public class Lion extends Role{
    private Integer id;

    public Lion(String name, Integer cd, String major, String part, Integer id) {
        super(name, cd, major, part);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public SubmissionPolicy getPolicy(){
        return new LionSubmissionPolicy();
    }

    @Override
    public String getDetailInfo(){
        return "🦁 역할: 아기사자\n"
                + "👤 이름: " + getName()
                + " | 🎓 전공: " + getMajor()
                + " | 📌 기수: " + getCd()
                + " | 💻 파트: " + getPart() + "\n"
                + "🆔 학번: " + id;
    }
}
