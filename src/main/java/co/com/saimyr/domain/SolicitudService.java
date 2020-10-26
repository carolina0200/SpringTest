package co.com.saimyr.domain;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class SolicitudService {
    private double total = 0;
    private final String ENDPOINT = "https://5f8ed3fd693e730016d7a909.mockapi.io/vivienda";

    private WebClient webClient;

    public SolicitudService() { this.webClient = WebClient.create(ENDPOINT); }

    public List<Solicitud> getAll() {
        return  this.webClient.get()
                .uri("/solicitudes")
                .retrieve()
                .bodyToFlux(Solicitud.class)
                .collectList().block();
    }

    public Solicitud save(Solicitud solicitud) {
        return  this.webClient.post().
                uri("/solicitudes")
                .body(Mono.just(solicitud), Solicitud.class)
                .retrieve()
                .bodyToMono(Solicitud.class)
                .block();
    }

    public Solicitud getSolicitud(int id) {
        return  this.webClient.get().
                uri("/solicitudes/" + id)
                .retrieve()
                .bodyToMono(Solicitud.class)
                .block();
    }

    public int tamanoGrupo(Solicitud solicitud) { return solicitud.getIntegrantes().size(); }

    public boolean parentezco(Solicitud solicitud) {
        boolean contiene = solicitud.getIntegrantes().stream().anyMatch(integrante -> integrante.getParentezco().equals("Jefe"));
        return contiene;
    }

    public double ingresos(Solicitud solicitud) {
        solicitud.getIntegrantes().forEach(i -> total += i.getIngresos());
        return  total;
    }

    public int puntaje(Solicitud solicitud) { return solicitud.getSisben(); }

}
