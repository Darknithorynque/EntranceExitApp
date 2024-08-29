package com.example.entrance_exit.Repository;

import com.example.entrance_exit.Entity.GateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Gate extends JpaRepository<GateEntity,Long> {
    Optional<GateEntity> findByGateName(String gate_name);
}
