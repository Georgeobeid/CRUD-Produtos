package com.test.testspring.repositry;

import com.test.testspring.modelos.ProdutoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositry extends JpaRepository<ProdutoModelo,Long> {
}
