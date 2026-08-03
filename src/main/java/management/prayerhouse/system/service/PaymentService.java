package management.prayerhouse.system.service;



import management.prayerhouse.system.entity.Payment;

import java.util.List;

public interface PaymentService {

    Payment savePayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(Long id);

    Payment updatePayment(Long id, Payment payment);

    void deletePayment(Long id);

    List<Payment> getPaymentsByMember(Long memberId);

    //Campaign
    List<Payment> getPaymentsByCampaign(Long campaignId);

}