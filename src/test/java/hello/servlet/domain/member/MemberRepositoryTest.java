package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach //각 테스트가 종료될 때 마다 이 기능을 실행한다.
    void afterEach() {
        // test 순서가 보장이되지않기때문에 테스트 종료후 store 를 정리해준다
        memberRepository.clearStore();
    }



    @Test
    void save() {
        //given 이런게주어졌을때
        Member member = new Member("hello", 20);

        //when 이런걸 실행했을때
        Member savedMember = memberRepository.save(member);

        //then 결과
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);
        //when
        memberRepository.save(member1);
        memberRepository.save(member2);

        //then
        List<Member> findMembers = memberRepository.findAll();


        assertThat(findMembers.size()).isEqualTo(2);
        assertThat(findMembers).contains(member1, member2);
    }
}