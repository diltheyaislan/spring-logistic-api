package com.diltheyaislan.springlogistic.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diltheyaislan.springlogistic.api.domain.model.Ocorrency;

@Repository
public interface OcorrencyRepository extends JpaRepository<Ocorrency, Long>  {

}
