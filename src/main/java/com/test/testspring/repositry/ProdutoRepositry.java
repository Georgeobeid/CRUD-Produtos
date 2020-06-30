package com.test.testspring.repositry;

import com.test.testspring.modelos.ProdutoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepositry extends JpaRepository<ProdutoModelo,Long> {

    List<ProdutoModelo> findByNome(String nome);
}
