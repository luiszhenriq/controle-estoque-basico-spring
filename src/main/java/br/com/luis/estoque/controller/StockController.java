package br.com.luis.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luis.estoque.domain.Product;
import br.com.luis.estoque.domain.ProductRegisterData;
import br.com.luis.estoque.domain.ProductRepository;
import br.com.luis.estoque.domain.ProductUpdateData;

@RestController
@RequestMapping("/produto")
public class StockController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    @Transactional
    public void addProduct(@RequestBody ProductRegisterData data) {
        repository.save(new Product(data));
    }

    @GetMapping
    public List<Product> list() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody ProductUpdateData data) {
        var product = repository.getReferenceById(data.id());
        product.updateProduct(data);
    }
}
