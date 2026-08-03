package management.prayerhouse.system.dto;



import java.math.BigDecimal;

public class CampaignReportResponse {

    private Long memberId;

    private String memberName;

    private String mobile;

    private BigDecimal requiredAmount;

    private BigDecimal paidAmount;

    private BigDecimal pendingAmount;

    private String status;

    public CampaignReportResponse() {
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public BigDecimal getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(BigDecimal requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(BigDecimal pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}