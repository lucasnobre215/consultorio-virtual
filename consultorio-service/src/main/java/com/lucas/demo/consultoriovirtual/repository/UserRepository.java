package com.lucas.demo.consultoriovirtual.repository;
    import java.util.List;

    import com.lucas.demo.consultoriovirtual.model.User;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;

@Repository
    public interface UserRepository extends CrudRepository<User, Long> {

        List<User> findByUsername(String username);

        User findById(long id);

}
