package reto2_psg.reto2_psg_c4.interfaces;


import reto2_psg.reto2_psg_c4.modelo.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author PSG94
 */
public interface InterfaceUser  extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
