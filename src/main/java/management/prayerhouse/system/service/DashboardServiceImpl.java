package management.prayerhouse.system.service;



import management.prayerhouse.system.dto.DashboardResponse;
import management.prayerhouse.system.repository.EventRepository;
import management.prayerhouse.system.repository.MemberRepository;
import management.prayerhouse.system.repository.PaymentRepository;
import management.prayerhouse.system.service.DashboardService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final MemberRepository memberRepository;
    private final PaymentRepository paymentRepository;
    private final EventRepository eventRepository;

    public DashboardServiceImpl(MemberRepository memberRepository,
                                PaymentRepository paymentRepository,
                                EventRepository eventRepository) {

        this.memberRepository = memberRepository;
        this.paymentRepository = paymentRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public DashboardResponse getDashboard() {

        DashboardResponse response = new DashboardResponse();

        response.setTotalMembers(memberRepository.count());

        response.setTotalPayments(paymentRepository.count());

        response.setTotalCollection(paymentRepository.getTotalCollection());

        response.setTodayCollection(
                paymentRepository.getTodayCollection(LocalDate.now()));

        response.setTodayEvents(
                eventRepository.countByEventDate(LocalDate.now()));

        return response;
    }
}