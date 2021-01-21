package university.innopolis.stc.springbestpractices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import university.innopolis.stc.springbestpractices.entity.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
