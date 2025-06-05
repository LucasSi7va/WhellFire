package com.WhellsFirePB.WhellsFirePB.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyappUserRepository extends JpaRepository<MyAppUser, Long> {

    Optional<MyAppUser> findByNome(String nome);

    MyAppUser findByEmail(String email);

}
