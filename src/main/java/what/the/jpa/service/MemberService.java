package what.the.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import what.the.jpa.domain.Member;
import what.the.jpa.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
//@AllArgsConstructor
@RequiredArgsConstructor // final이 있는것만 생성자 만들어줌
public class MemberService {

    private final MemberRepository memberRepository;

//    @Autowired // 생성자 하나뿐일 경우 생략 가능
//    public MemberService(MemberRepository memberRepository) {
//     ㄱ   this.memberRepository = memberRepository;
//    }

    // 회원 가입
    @Transactional
    public Long join(Member member) {
        // 중복 회원 검증
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

}
