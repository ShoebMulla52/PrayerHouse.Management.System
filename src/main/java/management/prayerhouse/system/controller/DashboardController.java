package management.prayerhouse.system.controller;



import management.prayerhouse.system.dto.DashboardResponse;
import management.prayerhouse.system.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/api/dashboard")
    public DashboardResponse getDashboard() {

        return dashboardService.getDashboard();

    }
}
