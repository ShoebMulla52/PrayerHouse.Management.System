package management.prayerhouse.system.service;
import management.prayerhouse.system.entity.Member;



import java.util.List;

public interface MemberService {

    Member saveMember(Member member);

    List<Member> getAllMembers();

    Member getMemberById(Long id);

    Member updateMember(Long id, Member member);

    void deleteMember(Long id);

}