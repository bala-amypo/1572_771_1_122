@Service
public class RoiServiceImpl implements RoiService {

    @Autowired
    private RoiReportRepository roiReportRepository;

    @Autowired
    private SaleTransactionRepository saleTransactionRepository;

    @Autowired
    private DiscountCodeRepository discountCodeRepository;

    @Override
    public RoiReport generateRoiForCode(Long codeId) {

        DiscountCode code = discountCodeRepository.findById(codeId)
                .orElseThrow(() -> new RuntimeException("Discount code not found"));

        List<SaleTransaction> transactions =
                saleTransactionRepository.findByDiscountCodeId(codeId);

        BigDecimal totalRevenue = transactions.stream()
                .map(SaleTransaction::getSaleAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalSales =
                BigDecimal.valueOf(transactions.size());

        BigDecimal roiPercentage = totalRevenue; // no cost given in question

        RoiReport report = new RoiReport();
        report.setCampaign(code.getCampaign());       // ✅ FIX
        report.setInfluencer(code.getInfluencer());   // ✅ FIX
        report.setTotalSales(totalSales);
        report.setTotalRevenue(totalRevenue);
        report.setRoiPercentage(roiPercentage);

        return roiReportRepository.save(report);
    }

    @Override
    public RoiReport getReportById(Long id) {
        return roiReportRepository.findById(id).orElse(null);
    }

    @Override
    public List<RoiReport> getReportsForInfluencer(Long influencerId) {
        return roiReportRepository.findByInfluencerId(influencerId);
    }

    @Override
    public List<RoiReport> getReportsForCampaign(Long campaignId) {
        return roiReportRepository.findByCampaignId(campaignId);
    }
}
