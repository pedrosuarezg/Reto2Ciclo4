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

    public Fragance update(Fragance accesory) {

        if (accesory.getReference() != null) {
            Optional<Fragance> accesoryDb = clotheRepository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {

                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                clotheRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
