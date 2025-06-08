package mk.ukim.finki.lab1b.service.application;

import mk.ukim.finki.lab1b.dto.CreateHostDto;
import mk.ukim.finki.lab1b.dto.DisplayHostDto;
import mk.ukim.finki.lab1b.model.domain.Host;
import mk.ukim.finki.lab1b.projections.HostByCountry;
import mk.ukim.finki.lab1b.projections.HostNameProjection;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {
    List<DisplayHostDto> findAll();
    Optional<DisplayHostDto> findById(Long id);
    Optional<DisplayHostDto> save(CreateHostDto host);
    Optional<DisplayHostDto> update(Long id,CreateHostDto host);
    void deleteById(Long id);
    List<HostByCountry> getHostCountByCountry();
    List<HostNameProjection> getAllHostNames();
}
