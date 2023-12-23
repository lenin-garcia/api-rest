package com.lgarcia.rest.controllers;

import com.lgarcia.rest.controllers.dto.ProductDTO;
import com.lgarcia.rest.entities.Product;
import com.lgarcia.rest.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductsService productService;

    @GetMapping ("/find/{id}")
    public ResponseEntity<?> finById(@PathVariable Long id) {

        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            //Creamos el DTO del producto
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .maker(product.getMaker())
                    .build();

            return ResponseEntity.ok(productDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
       List<ProductDTO> listaProduct = productService.findAll()
               .stream()
               .map(product -> ProductDTO.builder()
                       .id(product.getId())
                               .name(product.getName())
                               .price(product.getPrice())
                               .maker(product.getMaker())
                               .build()).toList();
       return ResponseEntity.ok(listaProduct);

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) throws URISyntaxException {

        //Si algunos de los datos viene con fallos devolvemos una mala request
        if (productDTO.getName().isBlank() || productDTO.getPrice() == null || productDTO.getMaker() == null ){
            return ResponseEntity.badRequest().build();
        }

        //si los datos son correctos contrsuimos el entity
        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .maker(productDTO.getMaker())
                .build();

        productService.save(product);
        return ResponseEntity.created(new URI("/api/product/save")).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if (id != null){
            productService.deleteById(id);
            return ResponseEntity.ok("Registro Eliminado!");
        }
    return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO product){

        Optional<Product> productoOptional = productService.findById(id);

        // si exiate proecedemos a actualizarlo con los valores del producto
        if(productoOptional.isPresent()){
            Product updateProduct = productoOptional.get();
            updateProduct.setName(product.getName());
            updateProduct.setPrice(product.getPrice());
            updateProduct.setMaker(product.getMaker());
            productService.save(updateProduct);// luego de actualizar los cambios hay que guardarlo
        }
        return ResponseEntity.notFound().build();
    }


}//fin
