package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{ // 구현체

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 0,1,2... key 값 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // id setting
        store.put(member.getId(), member); // map에 store
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store(map)에 있는 members가 반환됨.
    }

    public void clearStore() {
        store.clear();
    }
}
