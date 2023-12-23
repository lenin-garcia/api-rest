package com.lgarcia.rest.repository;

import com.lgarcia.rest.entities.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends CrudRepository <Maker,Long> {
}
