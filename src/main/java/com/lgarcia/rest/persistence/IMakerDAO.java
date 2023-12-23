package com.lgarcia.rest.persistence;
//metodos que va a tener nuestra application

import com.lgarcia.rest.entities.Maker;


import java.util.List;
import java.util.Optional;

public interface IMakerDAO {

    List<Maker> finAll();//devolvera un todos los fabricantes

    Optional<Maker> finById(Long id);//Devolvera un fabricante en dado caso lo consiga

    void save(Maker maker);//Almacenara un fabricante

    void deleteById(Long id);//Borrara un fabricante por el id
}
