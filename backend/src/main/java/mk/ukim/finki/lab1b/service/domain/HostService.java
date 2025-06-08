package mk.ukim.finki.lab1b.service.domain;

import mk.ukim.finki.lab1b.model.domain.Host;
import mk.ukim.finki.lab1b.projections.HostByCountry;
import mk.ukim.finki.lab1b.projections.HostNameProjection;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();
    Optional<Host> findById(Long id);
    Optional<Host> save(Host host);
    Optional<Host> update(Long id,Host host);
    void deleteById(Long id);
    List<HostByCountry> getHostCountByCountry();
    List<HostNameProjection> getAllHostNames();
}
