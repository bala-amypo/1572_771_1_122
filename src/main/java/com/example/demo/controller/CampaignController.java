@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    private final CampaignService service;

    public CampaignController(CampaignService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campaign> updateCampaign(
            @PathVariable Long id,
            @RequestBody Campaign c) {
        return ResponseEntity.ok(service.updateCampaign(id, c));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getCampaign(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCampaignById(id));
    }

    @GetMapping
    public ResponseEntity<List<Campaign>> getAllCampaigns() {
        return ResponseEntity.ok(service.getAllCampaigns());
    }
}
