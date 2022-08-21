package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/products")
public class ProductController {

    private ProductRepository productRepository;

    @ApiOperation(value = "Responsável por retornar uma mensagem de boas vindas.")
    @GetMapping("/welcome")
    public String messageWelcome() {
        return "Bem vindo a PRODUCT API REST.";
    }

    @ApiOperation(value = "Responsável por adicionar um produto.")
    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses( value = {
            @ApiResponse(code = 10, message = "Required fields not informed.")
    })
    public void addProduct(@RequestParam(name = "product") Product product) {
        if(product==null)
        productRepository.addProduct(product);
    }

    @ApiOperation(value = "Responsável por retornar uma lista de produtos.")
    @GetMapping(path = "/allProducts")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses( value = {
            @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    })
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @ApiOperation(value = "Responsável por retornar um produto pelo id.")
    @GetMapping(path = "/findProduct/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses( value = {
            @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    })
    public Product findProductById(@PathVariable Long id) {
        return productRepository. getProductById(id);
    }

    @ApiOperation(value = "Responsável por remover um produto.")
    @DeleteMapping(path = "/removeProduct", consumes = "application/json", produces = "application/json")
    @ApiResponses( value = {
            @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    })
    public void removeProduct(@RequestBody Product product) {
        productRepository.removeProduct(product);
    }

    @ApiOperation(value = "Responsável por atualizar um produto.")
    @PutMapping(path = "/updateProduct", consumes = "application/json", produces = "application/json")
    @ApiResponses( value = {
            @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    })
    public Product updadeProduct(@RequestBody Product product) {
        productRepository.updateProduct(product);
        return productRepository.getProductById(product.getId());
    }

}
