package com.lgarcia.rest.service;

import com.lgarcia.rest.entities.Maker;
import com.lgarcia.rest.persistence.IMakerDAO;

import java.util.List;
import java.util.Optional;

public interface IMarkerService  {


    List<Maker> finAll();//devolvera un todos los fabricantes

    Optional<Maker> finById(Long id);//Devolvera un fabricante en dado caso lo consiga

    void save(Maker maker);//Almacenara un fabricante

    void deleteById(Long id);//Borrara un fabricante por el id

}
