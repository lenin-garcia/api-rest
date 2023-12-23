package com.lgarcia.rest.service.impl;

import com.lgarcia.rest.entities.Maker;
import com.lgarcia.rest.persistence.IMakerDAO;
import com.lgarcia.rest.service.IMarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MarkerServiceImpl implements IMarkerService {

    @Autowired
    private IMakerDAO makerDAO;

    @Override
    public List<Maker> finAll() {
        return makerDAO.finAll();
    }

    @Override
    public Optional<Maker> finById(Long id) {
        return makerDAO.finById(id);
    }

    @Override
    public void save(Maker maker) {
        makerDAO.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerDAO.deleteById(id);
    }
}

