package management.prayerhouse.system.controller;



import management.prayerhouse.system.entity.Campaign;
import management.prayerhouse.system.service.CampaignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping
    public Campaign saveCampaign(@RequestBody Campaign campaign) {
        return campaignService.saveCampaign(campaign);
    }

    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    public Campaign getCampaignById(@PathVariable Long id) {
        return campaignService.getCampaignById(id);
    }

    @PutMapping("/{id}")
    public Campaign updateCampaign(@PathVariable Long id,
                                   @RequestBody Campaign campaign) {

        return campaignService.updateCampaign(id, campaign);
    }

    @DeleteMapping("/{id}")
    public String deleteCampaign(@PathVariable Long id) {

        campaignService.deleteCampaign(id);

        return "Campaign deleted successfully";
    }

}