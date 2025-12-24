public interface SaleTransactionService {
    SaleTransaction createSale(SaleTransaction tx);
    List<SaleTransaction> getSalesForCode(Long codeId);
    List<SaleTransaction> getSalesForInfluencer(Long influencerId);
    List<SaleTransaction> getSalesForCampaign(Long campaignId);
}
