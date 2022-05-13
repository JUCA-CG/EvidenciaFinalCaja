package net.codejava.repositories;

import net.codejava.entity.User;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author JCarlosC
 */

public interface UserRepository extends CrudRepository<User, Integer> {}
