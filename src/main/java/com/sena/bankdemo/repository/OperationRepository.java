package com.sena.bankdemo.repository;

import com.sena.bankdemo.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation,Integer> {

    @Query(value = "from Operation o where o.type = :type AND o.doneAt BETWEEN :startDate AND :endDate")
    List<Operation> getAllTransaction(@Param("type") int type, @Param("startDate") String startDate, @Param("endDate") String endDate);


}
