INSERT INTO member (name, major, part, generation, role_type, student_id, position) VALUES
                                                                                        ('박찬', '정보통신공학과', '백엔드', 9, 'LION', '20231234', NULL),
                                                                                        ('김영희', '소프트웨어학과', '프론트엔드', 9, 'LION', '20235678', NULL),
                                                                                        ('이철수', '정보통신공학과', '백엔드', 9, 'LION', '20239012', NULL),
                                                                                        ('박지민', '컴퓨터공학과', '백엔드', 8, 'STAFF', NULL, '운영진'),
                                                                                        ('최수연', '소프트웨어학과', '프론트엔드', 8, 'STAFF', NULL, '회장');
INSERT INTO member (name, major, part, generation, role_type, student_id, position) VALUES
                                                                                        ('정다은', '전자공학과', 'Backend', 9, 'LION', '20233456', NULL),
                                                                                        ('강민준', '산업공학과', 'Frontend', 9, 'LION', '20237890', NULL),
                                                                                        ('윤서아', '데이터사이언스학과', 'Backend', 9, 'LION', '20234567', NULL);
INSERT INTO assignment (title, description, member_id) VALUES
                                                           ('1주차 - OOP 기초', '클래스, 객체, 캡슐화 개념 학습 및 실습', 1),
                                                           ('2주차 - 상속과 다형성', '상속 구조 설계 및 다형성 활용 실습', 1),
                                                           ('7주차 - Spring Boot 마이그레이션', '순수 Java 프로젝트를 Spring Boot로 전환', 1),
                                                           ('9주차 - JPA 연관관계 매핑', 'Member-Assignment 1:N 양방향 관계 구현', 1),
                                                           ('7주차 - Spring Boot 마이그레이션', 'REST API와 DTO 설계', 2),
                                                           ('8주차 - JPA와 영속성 컨텍스트', 'JPA Repository 적용', 2),
                                                           ('9주차 - JPA 연관관계 매핑', '연관관계 주인 개념 정리', 3),
                                                           ('9주차 - JPA 연관관계 매핑', 'mappedBy와 @JoinColumn 학습', 6);