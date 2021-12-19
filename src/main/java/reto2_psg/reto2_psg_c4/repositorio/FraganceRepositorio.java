package reto2_psg.reto2_psg_c4.repositorio;

import reto2_psg.reto2_psg_c4.interfaces.InterfaceFragance;
import reto2_psg.reto2_psg_c4.modelo.Fragance;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author PSG94
 */
@Repository

public class FraganceRepositorio {

    @Autowired
    private InterfaceFragance repository;

    public List<Fragance> getAll() {
        return repository.findAll();
    }

    public Optional<Fragance> getFragance(String reference) {
        return repository.findById(reference);
    }
    public Fragance create(Fragance fragance) {
        return repository.save(fragance);
    }

    public void update(Fragance fragance) {
        repository.save(fragance);
    }

    public void delete(Fragance fragance) {
        repository.delete(fragance);
    }
}
