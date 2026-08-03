package management.prayerhouse.system.service;



import management.prayerhouse.system.entity.Campaign;

import java.util.List;

public interface CampaignService {

    Campaign saveCampaign(Campaign campaign);

    List<Campaign> getAllCampaigns();

    Campaign getCampaignById(Long id);

    Campaign updateCampaign(Long id, Campaign campaign);

    void deleteCampaign(Long id);

}
