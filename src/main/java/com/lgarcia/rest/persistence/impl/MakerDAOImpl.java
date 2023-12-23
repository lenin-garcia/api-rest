package com.lgarcia.rest.persistence.impl;

import com.lgarcia.rest.entities.Maker;
import com.lgarcia.rest.persistence.IMakerDAO;
import com.lgarcia.rest.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImpl implements IMakerDAO {

    //con esta inyeccion haremos las operaciones sobre la bbdd
    @Autowired
    private MakerRepository makerRepository;

    @Override
    public List<Maker> finAll() {
        return (List<Maker>) makerRepository.findAll();
    }

    @Override
    public Optional<Maker> finById(Long id) {
        return makerRepository.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerRepository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerRepository.deleteById(id);
    }
}
