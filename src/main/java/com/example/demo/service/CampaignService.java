public interface CampaignService {
    Campaign updateCampaign(Long id, Campaign campaign);
    Campaign getCampaignById(Long id);
    List<Campaign> getAllCampaigns();
}
