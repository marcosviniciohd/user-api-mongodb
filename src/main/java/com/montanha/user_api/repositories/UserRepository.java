package com.montanha.user_api.repositories;

import com.montanha.user_api.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


    User findByCpf(String cpf);

    User findByEmail(String email);

    User findByTelefone(String telefone);

    User findByNome(String nome);

    List<User> queryByNomeLike(String nome);

}
