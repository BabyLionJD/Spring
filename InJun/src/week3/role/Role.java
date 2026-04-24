package week3.role;

import week3.policy.Policy;

public abstract class Role {

        private String name; //이름
        private int cd; //cardinal number = 기수
        private String major; //전공
        private String part; // 벡/프론트 파트구분


        public Role (String name, String major, int cd, String part) {
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

        // 정책 객체를 각 자식이 반환하게 함
        public abstract Policy getPolicy();

        // 역할별 상세 정보 출력용
        public abstract String getDetailInfo();

        // 과제 제출 가능 여부 판단은 부모가 공통 처리
        public boolean submit() {
            return getPolicy().checkSub();
        }

    }


