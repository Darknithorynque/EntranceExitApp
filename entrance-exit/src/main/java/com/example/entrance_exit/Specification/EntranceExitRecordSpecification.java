package com.example.entrance_exit.Specification;

import com.example.entrance_exit.Entity.EntranceExitRecordEntity;
import com.example.entrance_exit.Entity.PersonalEntity;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class EntranceExitRecordSpecification {

    public static Specification<EntranceExitRecordEntity> hasStatus(String status){
        return (entranceExit, query, criteriaBuilder) -> {

            if(status.isEmpty() || status == null){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(entranceExit.get("status"),status);
        };
    }

    public static Specification<EntranceExitRecordEntity> hasPersonalName(String name){

        return (entranceExit, query, criteriaBuilder) -> {
            //concatenation of entrance table and personal
            Join<EntranceExitRecordEntity,PersonalEntity> personalEntityJoin = entranceExit.join("personalEntity");
            if(name.isEmpty()){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(personalEntityJoin.get("name"),name);
        };

    }

    public static Specification<EntranceExitRecordEntity> hasPersonalId(Long pid){

        return (entranceExit,query,criteriaBuilder) -> {
            Join<EntranceExitRecordEntity,PersonalEntity> personalEntityJoin = entranceExit.join("personalEntity");
            if (pid == null){
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(personalEntityJoin.get("id"),pid);
        };
    }

    public static Specification<EntranceExitRecordEntity> betweenDate(Date startDate, Date endDate){

        return (entranceExit, query, criteriaBuilder) -> {

            if (startDate == null || endDate == null){
                return criteriaBuilder.conjunction();
            }

            return criteriaBuilder.between(entranceExit.get("date"),startDate,endDate);
        };
    }
}
