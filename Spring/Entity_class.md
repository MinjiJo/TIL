# JPA anotation을 이용하여 Entity class를 만드는 방법

### Entity란?
Entity는 DB에서 영속적으로 저장된 데이터를 자바 객체로 매핑하여 '인스턴스의 형태'로 존재하는 데이터를 말합니다.

1. Maven-pom.xml, application.properties 를 각각 설정
2. class에 Entity 설정
```java
@Entity
@Table(name="users")
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private bigint seq;
    private String name;
    private String email;
    private String passwd;
    private String profile_image_url;
    private int login_count;
    private datetime last_login_at;
    private datetime create_at;
}
```

- @Entity : Entity 클래스
- @Table(name="category") : 매핑할 테이블 명
- @Getter / @Setter : getters/setters 생성 롬복(Lombok) 애노테이션
- @Id : 기본키 설정. cf)복합키가 기본키인 경우 @Embeddedid
- @GeneratedValue(strategy = GenerationType.IDENTITY) : JPA에 기본키 생성
- @Column : Entity 클래스는 DB컬럼과 매핑되어 따로 명시하지 않아도 되지만, 컬럼명이 다른 것이나 default값이 다른 경우 아래와 같이 사용한다.

```java
    @Column(length = 100, nullable = false) 
    private String name;
    
    @Column(nullable = false)
    private int price;

    //카멢 표기법 -> 스네이크 소문자 표기법
    //length=255, nullable에서 true=default값
```
