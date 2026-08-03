package management.prayerhouse.system.dto;


import java.math.BigDecimal;

public class DashboardResponse {

    private Long totalMembers;

    private Long totalPayments;

    private BigDecimal totalCollection;

    private BigDecimal todayCollection;

    private Long todayEvents;

    public Long getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(Long totalMembers) {
        this.totalMembers = totalMembers;
    }

    public Long getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(Long totalPayments) {
        this.totalPayments = totalPayments;
    }

    public BigDecimal getTotalCollection() {
        return totalCollection;
    }

    public void setTotalCollection(BigDecimal totalCollection) {
        this.totalCollection = totalCollection;
    }

    public BigDecimal getTodayCollection() {
        return todayCollection;
    }

    public void setTodayCollection(BigDecimal todayCollection) {
        this.todayCollection = todayCollection;
    }

    public Long getTodayEvents() {
        return todayEvents;
    }

    public void setTodayEvents(Long todayEvents) {
        this.todayEvents = todayEvents;
    }
}