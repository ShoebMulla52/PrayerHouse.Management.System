package management.prayerhouse.system.service;

import management.prayerhouse.system.entity.Member;
import management.prayerhouse.system.repository.MemberRepository;
import management.prayerhouse.system.service.MemberService;



import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public Member updateMember(Long id, Member member) {

        Member existingMember = memberRepository.findById(id).orElse(null);

        if (existingMember == null) {
            return null;
        }

        existingMember.setName(member.getName());
        existingMember.setMobile(member.getMobile());
        existingMember.setAddress(member.getAddress());

        return memberRepository.save(existingMember);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}