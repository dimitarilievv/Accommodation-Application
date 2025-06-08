package mk.ukim.finki.lab1b.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.ukim.finki.lab1b.dto.CreateHostDto;
import mk.ukim.finki.lab1b.dto.DisplayHostDto;
import mk.ukim.finki.lab1b.projections.HostByCountry;
import mk.ukim.finki.lab1b.projections.HostNameProjection;
import mk.ukim.finki.lab1b.repository.HostRepository;
import mk.ukim.finki.lab1b.service.application.HostApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hosts")
@Tag(name = "Host Controller", description = "Operations related to hosts")
public class HostController {
    private final HostApplicationService hostService;
    private final HostRepository hostRepository;

    public HostController(HostApplicationService hostService, HostRepository hostRepository) {
        this.hostService = hostService;
        this.hostRepository = hostRepository;
    }

    @GetMapping
    @Operation(summary = "Get all hosts", description = "Returns a list of all hosts")
    public List<DisplayHostDto> findAll(){
        return hostService.findAll();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get host by ID", description = "Returns a single host by its ID")
    public ResponseEntity<DisplayHostDto> findById(@PathVariable Long id) {
        return hostService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @Operation(summary = "Add a new host", description = "Creates and returns a new host")
    public ResponseEntity<DisplayHostDto> save(@RequestBody CreateHostDto host){
        return hostService.save(host)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Update an existing host", description = "Updates a host by its ID")
    public ResponseEntity<DisplayHostDto> update(@PathVariable Long id, @RequestBody CreateHostDto host) {
        return hostService.update(id, host)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a host", description = "Deletes a host by its ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (hostService.findById(id).isPresent()) {
            hostService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/by-country")
    public List<HostByCountry> getHostCountByCountry() {
        return hostService.getHostCountByCountry();
    }

    @GetMapping("/api/hosts/names")
    public List<HostNameProjection> getAllHostNames() {
        return hostService.getAllHostNames();
    }
}
