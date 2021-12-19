package reto2_psg.reto2_psg_c4.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto2_psg.reto2_psg_c4.modelo.Fragance;
import reto2_psg.reto2_psg_c4.repositorio.FraganceRepositorio;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author PSG94
 */
@Service
public class FraganceService {
    @Autowired
    private FraganceRepositorio fraganceRepositorio;

    public List<Fragance> getAll() {
        return fraganceRepositorio.getAll();
    }

    public Optional<Fragance> getFragance(String reference) {
        return fraganceRepositorio.getFragance(reference);
    }

    public Fragance create(Fragance fragance) {
        if (fragance.getReference() == null) {
            return fragance;
        } else {
            return fraganceRepositorio.create(fragance);
        }
    }

    public Fragance update(Fragance fragance) {

        if (fragance.getReference() != null) {
            Optional<Fragance> fraganceDb = fraganceRepositorio.getFragance(fragance.getReference());
            if (!fraganceDb.isEmpty()) {

                if (fragance.getBrand()!= null) {
                    fraganceDb.get().setBrand(fragance.getBrand());
                }

                if (fragance.getCategory() != null) {
                    fraganceDb.get().setCategory(fragance.getCategory());
                }

                if (fragance.getPresentation() != null) {
                    fraganceDb.get().setPresentation(fragance.getPresentation());
                }

                if (fragance.getDescription() != null) {
                    fraganceDb.get().setDescription(fragance.getDescription());
                }
                if (fragance.getPrice() != 0.0) {
                    fraganceDb.get().setPrice(fragance.getPrice());
                }
                if (fragance.getQuantity() != 0) {
                    fraganceDb.get().setQuantity(fragance.getQuantity());
                }
                if (fragance.getPhotography() != null) {
                    fraganceDb.get().setPhotography(fragance.getPhotography());
                }
                fraganceDb.get().setAvailability(fragance.isAvailability());
                fraganceRepositorio.update(fraganceDb.get());
                return fraganceDb.get();
            } else {
                return fragance;
            }
        } else {
            return fragance;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getFragance(reference).map(fragance -> {
            fraganceRepositorio.delete(fragance);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
