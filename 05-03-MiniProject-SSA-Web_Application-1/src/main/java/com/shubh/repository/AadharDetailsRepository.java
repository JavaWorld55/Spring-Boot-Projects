package com.shubh.repository;

import org.springframework.data.repository.CrudRepository;

import com.shubh.entity.AadharDetailsEntity;

public interface AadharDetailsRepository extends CrudRepository<AadharDetailsEntity, Integer> {

	public AadharDetailsEntity findByAadharNo(Long aadharNo);
}
