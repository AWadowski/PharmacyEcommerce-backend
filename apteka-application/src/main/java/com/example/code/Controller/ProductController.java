package com.example.code.Controller;

import com.example.code.Api.ProductApi;
import com.example.code.Api.TypProduktu;
import com.example.code.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/produkty")
public class ProductController {


    private final ProductService productService;

    @GetMapping("/getAll")
    public List<ProductApi> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductApi getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductApi productApi) {
        productService.addProduct(productApi);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody ProductApi updatedProductApi) {
        productService.updateProduct(id, updatedProductApi);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/descriptionNotNull")
    public List<ProductApi> getProductsByDescriptionNotNull() {
        return productService.findProductsByDescriptionNotNull();
    }

    @GetMapping("/priceRange")
    public List<ProductApi> getProductsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return productService.findProductsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/priceGreaterThanOrEqual")
    public List<ProductApi> getProductsByPriceGreaterThanOrEqual(@RequestParam double price) {
        return productService.findProductsByPriceGreaterThanOrEqual(price);
    }

    @GetMapping("/nameContaining")
    public List<ProductApi> getProductsByNameContaining(@RequestParam String name) {
        return productService.findProductsByNameContaining(name);
    }

    @GetMapping("/typProduktu/{typProduktu}")
    public List<ProductApi> getProductsByTypProduktu(@PathVariable String typProduktu) {
        return productService.findProductsByTypProduktu(typProduktu);
    }

}