package com.laiscarvalho.userapi;

import com.laiscarvalho.userapi.repository.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByCPF(String cpf);

    List<User> findByNameLike(String name);
}