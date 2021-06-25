package com.zps.qr.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zps.qr.db.model.Code;

@Repository
public interface CodeRepository extends JpaRepository<Code, Long > {

}