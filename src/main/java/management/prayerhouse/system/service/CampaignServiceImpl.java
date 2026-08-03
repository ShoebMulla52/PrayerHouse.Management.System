package management.prayerhouse.system.service;



import management.prayerhouse.system.entity.Campaign;
import management.prayerhouse.system.repository.CampaignRepository;
import management.prayerhouse.system.service.CampaignService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign saveCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    @Override
    public Campaign getCampaignById(Long id) {
        return campaignRepository.findById(id).orElse(null);
    }

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {

        Campaign existingCampaign = campaignRepository.findById(id).orElse(null);

        if (existingCampaign == null) {
            return null;
        }

        existingCampaign.setTitle(campaign.getTitle());
        existingCampaign.setDescription(campaign.getDescription());
        existingCampaign.setTargetAmount(campaign.getTargetAmount());
        existingCampaign.setContributionPerMember(campaign.getContributionPerMember());
        existingCampaign.setStartDate(campaign.getStartDate());
        existingCampaign.setEndDate(campaign.getEndDate());
        existingCampaign.setStatus(campaign.getStatus());

        return campaignRepository.save(existingCampaign);
    }

    @Override
    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
    }
}
