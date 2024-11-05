package com.exemplo.padaria.controller;

import com.exemplo.padaria.model.Produto;
import com.exemplo.padaria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return produtoService.adicionarProduto(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public Produto obterProdutoPorId(@PathVariable int id) {
        return produtoService.obterProdutoPorId(id);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable int id, @RequestBody Produto produtoAtualizado) {
        return produtoService.atualizarProduto(id, produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable int id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
