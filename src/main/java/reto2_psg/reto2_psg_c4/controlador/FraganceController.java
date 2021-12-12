package reto2_psg.reto2_psg_c4.controlador;

import reto2_psg.reto2_psg_c4.servicio.FraganceService;
import reto2_psg.reto2_psg_c4.modelo.Fragance;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/api/fragance")
@CrossOrigin("*")
public class FraganceController {
        @Autowired
        private FraganceService accessoryService;

        @GetMapping("/all")
        public List<Fragance> getAll() {
            return accessoryService.getAll();
        }

        @GetMapping("/{reference}")
        public Optional<Fragance> getClothe(@PathVariable("reference") String reference) {
            return accessoryService.getClothe(reference);
        }

        @PostMapping("/new")
        @ResponseStatus(HttpStatus.CREATED)
        public Fragance create(@RequestBody Fragance gadget) {
            return accessoryService.create(gadget);
        }

        @PutMapping("/update")
        @ResponseStatus(HttpStatus.CREATED)
        public Fragance update(@RequestBody Fragance gadget) {
            return accessoryService.update(gadget);
        }

        @DeleteMapping("/{reference}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public boolean delete(@PathVariable("reference") String reference) {
            return accessoryService.delete(reference);
        }
    }
