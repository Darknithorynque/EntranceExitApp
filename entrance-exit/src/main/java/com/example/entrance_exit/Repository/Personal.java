package com.example.entrance_exit.Repository;

import com.example.entrance_exit.Entity.PersonalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface Personal extends JpaRepository<PersonalEntity, Long>, JpaSpecificationExecutor<PersonalEntity> {
}
