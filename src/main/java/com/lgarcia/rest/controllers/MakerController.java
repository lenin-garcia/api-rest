package com.lgarcia.rest.controllers;

import com.lgarcia.rest.controllers.dto.MakerDTO;
import com.lgarcia.rest.entities.Maker;
import com.lgarcia.rest.service.IMarkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/api/maker")
public class MakerController {

    @Autowired
    private IMarkerService markerService;

    @GetMapping("/find/{id}")
  public ResponseEntity<?> findByID(@PathVariable Long id) {
        Optional<Maker> makerOptional = markerService.finById(id);

        //no se puede retornar un objeto entity, es mala practica se tiene que retornar un dto
        //pasamos el maker a un dto
        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get(); //ontenemos la entidad
            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build();

            // Retornamos una respuesta exitosa (código 200) con el DTO como cuerpo
           return ResponseEntity.ok(makerDTO);
        }

        // Si el Maker no fue encontrado, retornamos una respuesta de "no encontrado" (código 404)
        return notFound().build();

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<MakerDTO> makerList = markerService.finAll()
                .stream()
                .map(maker -> MakerDTO.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .productList(maker.getProductList())
                        .build()
                ).toList();
        return ResponseEntity.ok(makerList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MakerDTO makerDTO) throws URISyntaxException {

        //evaluamos si el dto tiene nombre
        if(makerDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        //si no esta vacio, almacenara, estamos seteando el nombre
        markerService.save(Maker.builder()
                .name(makerDTO
                        .getName())
                .build());
        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Maker makerDTO){

        //verificacmos que exista el fabricante
       Optional<Maker> updatMaker= markerService.finById(id);

       if(updatMaker.isPresent()){
            Maker maker = updatMaker.get(); //recuperamos el entity
           maker.setName(makerDTO.getName()); //cambiamos el nombre
            markerService.save(maker);//volvemos a guardar
           return ResponseEntity.ok("Registro actualizado!");
       }

       return ResponseEntity.notFound().build();// en dado caso no la consiga
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        // si el id es correcto
        if (id != null) {
            markerService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }

       return ResponseEntity.badRequest().build();
    }



}//fin


