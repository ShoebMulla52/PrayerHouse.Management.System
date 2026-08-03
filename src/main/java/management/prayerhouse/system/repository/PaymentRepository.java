package management.prayerhouse.system.repository;

import management.prayerhouse.system.entity.Campaign;
import management.prayerhouse.system.entity.Member;
import management.prayerhouse.system.entity.Payment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Get all payments of a member
    List<Payment> findByMember(Member member);

    // Get payments by month and year
    List<Payment> findByMonthAndYear(Integer month, Integer year);

    List<Payment> findByCampaign(Campaign campaign);


    @Query("SELECT COALESCE(SUM(p.amount),0) FROM Payment p")
    BigDecimal getTotalCollection();

    @Query("SELECT COALESCE(SUM(p.amount),0) FROM Payment p WHERE p.paymentDate=:date")
    BigDecimal getTodayCollection(LocalDate date);


    @Query("""
SELECT COALESCE(SUM(p.amount),0)
FROM Payment p
WHERE p.member.id = :memberId
AND p.campaign.id = :campaignId
""")
    BigDecimal getTotalPaidByMemberAndCampaign(
            @Param("memberId") Long memberId,
            @Param("campaignId") Long campaignId
    );



}