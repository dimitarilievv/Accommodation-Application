package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.domain.Accommodation;
import mk.ukim.finki.lab1b.model.domain.Country;
import mk.ukim.finki.lab1b.model.domain.Host;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayHostDto(Long id,String name, String surname, Country country) {
    public static DisplayHostDto from(Host host){
        return new DisplayHostDto(host.getId(),host.getName(),host.getSurname(),host.getCountry());
    }
    public static List<DisplayHostDto> from(List<Host> hosts){
        return hosts.stream()
                .map(DisplayHostDto::from)
                .collect(Collectors.toList());
    }
}
