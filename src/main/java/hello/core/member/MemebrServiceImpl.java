package hello.core.member;

import org.springframework.stereotype.Service;

public class MemebrServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemebrServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member)    {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
