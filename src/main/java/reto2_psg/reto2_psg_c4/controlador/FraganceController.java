package reto2_psg.reto2_psg_c4.controlador;

import java.util.List;
import java.util.Optional;

import reto2_psg.reto2_psg_c4.modelo.Fragance;
import reto2_psg.reto2_psg_c4.servicio.FraganceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/api/fragance")
@CrossOrigin("*")
public class FraganceController {
        @Autowired
        private FraganceService fraganceService;

        @GetMapping("/all")
        public List<Fragance> getAll() {
            return fraganceService.getAll();
        }

        @GetMapping("/{reference}")
        public Optional<Fragance> getClothe(@PathVariable("reference") String reference) {
            return fraganceService.getClothe(reference);
        }

        @PostMapping("/new")
        @ResponseStatus(HttpStatus.CREATED)
        public Fragance create(@RequestBody Fragance fragance) {
            return fraganceService.create(fragance);
        }

        @PutMapping("/update")
        @ResponseStatus(HttpStatus.CREATED)
        public Fragance update(@RequestBody Fragance fragance) {
            return fraganceService.update(fragance);
        }

        @DeleteMapping("/{reference}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public boolean delete(@PathVariable("reference") String reference) {
            return fraganceService.delete(reference);
        }
    }
