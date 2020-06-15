package com.test.testspring.controllers;

import com.test.testspring.modelos.ProdutoModelo;
import com.test.testspring.repositry.ProdutoRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoRepositry produtoRepositry;

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoModelo>> getAllProdutos(){
        List<ProdutoModelo> produtoModelos=produtoRepositry.findAll();
        if (produtoModelos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<ProdutoModelo>>(produtoModelos,HttpStatus.OK);
        }
    }

//    @GetMapping("/produtos")
//    public List<ProdutoModelo> getAllprodutos(){
//    List<ProdutoModelo> produtoModelos = produtoRepositry.findAll();
//    return produtoModelos;
//    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<ProdutoModelo> getOneProduto( @PathVariable(value = "id") long id){
        Optional<ProdutoModelo> produto=produtoRepositry.findById(id);
        if (!produto.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<ProdutoModelo>(produto.get(),HttpStatus.OK);
        }
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<ProdutoModelo> updateProduto(@PathVariable(value = "id") long id, @RequestBody @Validated ProdutoModelo produtoE){
        Optional<ProdutoModelo> produto=produtoRepositry.findById(id);
        if (!produto.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            produtoE.setIdProduto(produto.get().getIdProduto());
            return new ResponseEntity<ProdutoModelo>(produtoRepositry.save(produtoE),HttpStatus.OK);
        }
    }

//    @PostMapping("/produtos")
//    public ResponseEntity<ProdutoModelo> saveProduto( @RequestBody @Validated ProdutoModelo produtoE){
//        return new ResponseEntity<ProdutoModelo>(produtoRepositry.save(produtoE),HttpStatus.CREATED);
//    }

    @PostMapping("/produtos")
    public ProdutoModelo saveProduto(@RequestBody ProdutoModelo produtoE){
        return produtoRepositry.save(produtoE);
    }


    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<ProdutoModelo> updateProduto(@PathVariable(value = "id") long id){
        Optional<ProdutoModelo> produto=produtoRepositry.findById(id);
        if (!produto.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            produtoRepositry.delete(produto.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
