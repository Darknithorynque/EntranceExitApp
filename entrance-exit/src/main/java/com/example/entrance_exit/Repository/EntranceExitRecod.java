package com.example.entrance_exit.Repository;

import com.example.entrance_exit.Entity.EntranceExitRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EntranceExitRecod extends JpaRepository<EntranceExitRecordEntity, Long>, JpaSpecificationExecutor<EntranceExitRecordEntity> {
}
