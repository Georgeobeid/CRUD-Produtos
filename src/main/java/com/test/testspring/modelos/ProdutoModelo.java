package com.test.testspring.modelos;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoModelo implements Serializable {

    public static final Long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProduto;

    private String nome;

    private double valor;

}
