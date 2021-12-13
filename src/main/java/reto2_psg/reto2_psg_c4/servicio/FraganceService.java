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
    private FraganceRepositorio clotheRepository;

    public List<Fragance> getAll() {
        return clotheRepository.getAll();
    }

    public Optional<Fragance> getClothe(String reference) {
        return clotheRepository.getClothe(reference);
    }

    public Fragance create(Fragance accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }

    public Fragance update(Fragance fragance) {

        if (fragance.getReference() != null) {
            Optional<Fragance> fraganceDb = clotheRepository.getClothe(fragance.getReference());
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
                clotheRepository.update(fraganceDb.get());
                return fraganceDb.get();
            } else {
                return fragance;
            }
        } else {
            return fragance;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(fragance -> {
            clotheRepository.delete(fragance);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
