package com.example.entrance_exit.Specification;

import com.example.entrance_exit.Entity.PersonalEntity;
import org.springframework.data.jpa.domain.Specification;

public class PersonalSpecification {

    public static Specification<PersonalEntity> hasRole(String role) {

        return (personal, query, criteriaBuilder) -> {
            if(role == null || role.isEmpty()){
                return criteriaBuilder.conjunction(); //no filter
            }
            return criteriaBuilder.equal(personal.get("role"),role);
        };
    }

    public static Specification<PersonalEntity> hasName(String name) {

        return (personal, query, criteriaBuilder) -> {
            if(name == null || name.isEmpty()){
                return criteriaBuilder.conjunction(); //no filter
            }
            return criteriaBuilder.equal(personal.get("name"),name);
        };
    }

    public static Specification<PersonalEntity> hasAgeBetween(int minAge, int maxAge) {

        return (personal, query, criteriaBuilder) -> {
            return criteriaBuilder.between(personal.get("age"),minAge, maxAge);
        };
    }
}
