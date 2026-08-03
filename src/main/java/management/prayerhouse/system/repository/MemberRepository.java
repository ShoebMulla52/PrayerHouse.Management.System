package management.prayerhouse.system.repository;

import management.prayerhouse.system.entity.Member;


import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
