package com.exemplo.padaria.service;

import com.exemplo.padaria.model.Produto;
import com.exemplo.padaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto obterProdutoPorId(int id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto atualizarProduto(int id, Produto produtoAtualizado) {
        Produto produto = obterProdutoPorId(id);
        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setImagem(produtoAtualizado.getImagem());
        return produtoRepository.save(produto);
    }

    public void deletarProduto(int id) {
        Produto produto = obterProdutoPorId(id);
        produtoRepository.delete(produto);
    }
}
