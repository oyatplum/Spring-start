package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository { //회원 객체 저장소
    Member save(Member member); // 회원 저장
    Optional<Member> findById(Long id); // id로 회원 찾기
    Optional<Member> findByName(String name); // name으로 회원 찾기
    List<Member> findAll(); // 회원 리스트 모두 찾기
}
