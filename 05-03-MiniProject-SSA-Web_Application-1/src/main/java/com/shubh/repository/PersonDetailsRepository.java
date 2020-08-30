package com.shubh.repository;

import org.springframework.data.repository.CrudRepository;

import com.shubh.entity.PersonDetailsEntity;

public interface PersonDetailsRepository extends CrudRepository<PersonDetailsEntity, Integer> {

}
