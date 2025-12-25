@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    private final CampaignService service;

    public CampaignController(CampaignService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Campaign> create(@RequestBody Campaign campaign) {
        return ResponseEntity.ok(service.create(campaign));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campaign> update(@PathVariable Long id,
                                           @RequestBody Campaign campaign) {
        return ResponseEntity.ok(service.update(id, campaign));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    public ResponseEntity<List<Campaign>> list() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        service.deactivate(id);
        return ResponseEntity.noContent().build();
    }
}
