public interface DiscountCodeService {
    DiscountCode getDiscountCodeById(Long id);
    DiscountCode updateDiscountCode(Long id, DiscountCode code);
    List<DiscountCode> getCodesForInfluencer(Long influencerId);
    List<DiscountCode> getCodesForCampaign(Long campaignId);
}
