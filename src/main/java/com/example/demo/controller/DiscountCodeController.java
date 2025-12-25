@RestController
@RequestMapping("/api/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService service;

    public DiscountCodeController(DiscountCodeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DiscountCode> create(@RequestBody DiscountCode dc) {
        return ResponseEntity.ok(service.create(dc));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCode> update(@PathVariable Long id,
                                               @RequestBody DiscountCode dc) {
        return ResponseEntity.ok(service.update(id, dc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCode> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<?> byInfluencer(@PathVariable Long influencerId) {
        return ResponseEntity.ok(service.byInfluencer(influencerId));
    }

    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<?> byCampaign(@PathVariable Long campaignId) {
        return ResponseEntity.ok(service.byCampaign(campaignId));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        service.deactivate(id);
        return ResponseEntity.noContent().build();
    }
}
