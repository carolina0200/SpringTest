package co.com.saimyr.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SolicitudController {
    private SolicitudService solicitudService = new SolicitudService();

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<Solicitud>> getAllForms() {
        return new ResponseEntity<>(solicitudService.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Solicitud> save(@RequestBody Solicitud solicitud) {
        return new ResponseEntity<>(solicitudService.save(solicitud), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Solicitud> get(@PathVariable("id") int id) {
        return new ResponseEntity<>(solicitudService.getSolicitud(id), HttpStatus.OK);
    }
}
