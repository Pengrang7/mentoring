// DB의 'member' 테이블과 연결되는 자바 클래스.
// DB에 저장할 회원 정보(이름, 아이디, 비밀번호 등)를 정의하고 관리.

package com.example.mentoring.entity; // 이 파일이 프로젝트 내에서 어디에 위치하는지 나타냄.

import jakarta.persistence.*; // DB와 연결하기 위해 사용하는 라이브러리.
import lombok.Data; // 간단하게 코드를 줄일 수 있도록 도와주는 라이브러리.
import org.hibernate.annotations.CreationTimestamp; // 생성 시간(가입 날짜)을 자동으로 저장해주는 기능.
import org.springframework.format.annotation.DateTimeFormat; // 날짜를 특정한 형식(예: yyyy-MM-dd)으로 관리.

import java.util.Date; // 날짜와 시간을 다루는 데 사용하는 클래스.

import com.example.mentoring.dto.MemberDTO; // 회원 정보를 담는 또 다른 클래스. 데이터를 쉽게 변환하기 위해 사용.

@Entity // 이 클래스가 DB의 테이블과 연결된다는 것을 나타냄.
//region @Getter, @Setter 대신 @Data 를 쓰는 이유
//    코드 간소화:
//    @Getter와 @Setter를 각각 모든 클래스에 추가하려면 코드가 길어질 수 있음.
//
//    @Data는 Lombok 라이브러리에서 제공하는 어노테이션으로, 다음 기능을 한 번에 제공:
//        @Getter: 모든 필드에 대해 getter 메서드 생성.
//        @Setter: 모든 필드에 대해 setter 메서드 생성.
//        @ToString: 객체의 내용을 출력할 수 있는 toString 메서드 생성.
//        @EqualsAndHashCode: 객체 비교를 위한 equals와 hashCode 메서드 생성.
//        @RequiredArgsConstructor: final 필드나 @NonNull 필드에 대한 생성자 생성.
//
//  주의 사항
//      무분별한 Setter 남용 : 변하지 않아야 하는 값이 바뀔 가능성이 존재
//      객체가 양방향 연관 관계일 경우 ToString을 호출하면 무한 순환 참조 발생
//endregion
@Data // getter, setter, toString 같은 자주 쓰는 메서드를 자동으로 만들어줌.
@Table(name = "member") // 이 클래스가 DB의 'member'라는 테이블과 연결됨을 나타냄.
public class MemberEntity {
    @Id // 이 필드는 DB에서 각 데이터를 구별하는 고유한 키(Primary Key)로 사용.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key를 DB가 자동으로 생성하도록 설정.
    private Long idx; // 회원을 식별하기 위한 고유 번호.

    @Column(name = "member_name", nullable = false, length = 20) // 테이블의 'member_name' 컬럼과 연결.
    private String name; // 회원의 이름을 저장.

    @Column(name = "member_id", nullable = false, length = 30) // 테이블의 'member_id' 컬럼과 연결.
    private String Id; // 회원의 아이디(로그인용)를 저장.

    @Column(name = "member_password", nullable = false) // 테이블의 'member_password' 컬럼과 연결.
    private String password; // 회원의 비밀번호를 저장.

    @Column(name = "phone_number", length = 13) // 테이블의 'phone_number' 컬럼과 연결.
    private String phone; // 회원의 전화번호를 저장.

    @Column(name = "member_email", length = 30) // 테이블의 'member_email' 컬럼과 연결.
    private String email; // 회원의 이메일 주소를 저장.

    @Column(name = "member_birth") // 테이블의 'member_birth' 컬럼과 연결.
    @Temporal(TemporalType.DATE) // 날짜 형식으로 데이터를 저장.
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 날짜를 'yyyy-MM-dd' 형식으로 읽고, 저장.
    private Date birth; // 회원의 생년월일을 저장.

    @CreationTimestamp // 데이터가 생성될 때(가입할 때) 자동으로 현재 날짜를 저장.
    @Column(name = "join_date", updatable = false) // 테이블의 'join_date' 컬럼과 연결.
    @Temporal(TemporalType.DATE) // 날짜 형식으로 데이터를 저장.
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 날짜를 'yyyy-MM-dd' 형식으로 읽고, 저장.
    private Date joinDate; // 회원이 가입한 날짜를 저장.

    // DTO에서 Entity로 변환해주는 메서드.
    // DTO는 데이터를 전달하기 위한 객체이고, Entity는 DB와 직접 연결되는 객체.
    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity(); // 새로운 MemberEntity 객체를 만듦.
        memberEntity.setName(memberDTO.getName()); // DTO에 담긴 이름을 Entity에 복사.
        memberEntity.setPassword(memberDTO.getPassword()); // DTO에 담긴 비밀번호를 Entity에 복사.
        memberEntity.setEmail(memberDTO.getEmail()); // DTO에 담긴 이메일을 Entity에 복사.
        memberEntity.setBirth(memberDTO.getBirth()); // DTO에 담긴 생년월일을 Entity에 복사.
        memberEntity.setPhone(memberDTO.getPhone()); // DTO에 담긴 전화번호를 Entity에 복사.
        memberEntity.setId(memberDTO.getId()); // DTO에 담긴 아이디를 Entity에 복사.
        return memberEntity; // 완성된 Entity 객체를 반환.
    }
}
