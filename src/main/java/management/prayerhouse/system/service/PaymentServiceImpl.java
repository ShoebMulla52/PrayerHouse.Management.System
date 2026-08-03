package management.prayerhouse.system.service;

import management.prayerhouse.system.entity.Campaign;
import management.prayerhouse.system.entity.Member;
import management.prayerhouse.system.entity.Payment;
import management.prayerhouse.system.repository.CampaignRepository;
import management.prayerhouse.system.repository.MemberRepository;
import management.prayerhouse.system.repository.PaymentRepository;
import management.prayerhouse.system.service.PaymentService;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final MemberRepository memberRepository;

    // Campaign
    private final CampaignRepository campaignRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              MemberRepository memberRepository,
                              CampaignRepository campaignRepository){

        this.paymentRepository = paymentRepository;
        this.memberRepository = memberRepository;
        this.campaignRepository = campaignRepository;
    }



    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {

        Payment existingPayment = paymentRepository.findById(id).orElse(null);

        if (existingPayment == null) {
            return null;
        }

        existingPayment.setAmount(payment.getAmount());
        existingPayment.setPaymentDate(payment.getPaymentDate());
        existingPayment.setPaymentTime(payment.getPaymentTime());
        existingPayment.setPaymentMode(payment.getPaymentMode());
        existingPayment.setRemarks(payment.getRemarks());
        existingPayment.setMonth(payment.getMonth());
        existingPayment.setYear(payment.getYear());

        return paymentRepository.save(existingPayment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<Payment> getPaymentsByMember(Long memberId) {

        Member member = memberRepository.findById(memberId).orElse(null);

        if (member == null) {
            return List.of();
        }

        return paymentRepository.findByMember(member);



    }

    @Override
    public List<Payment> getPaymentsByCampaign(Long campaignId) {

        Campaign campaign = campaignRepository.findById(campaignId).orElse(null);
        if(campaign == null){
            return List.of();
        }

        return paymentRepository.findByCampaign(campaign);

    }
}