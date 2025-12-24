public interface DiscountCodeService {
    DiscountCode getDiscountCodeById(Long id);
    DiscountCode updateDiscountCode(Long id, DiscountCode dc);
    List<DiscountCode> getCodesForInfluencer(Long influencerId);
    List<DiscountCode> getCodesForCampaign(Long campaignId);
}
