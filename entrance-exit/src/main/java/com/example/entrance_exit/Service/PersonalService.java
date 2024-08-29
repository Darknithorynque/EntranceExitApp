package com.example.entrance_exit.Service;

import com.example.entrance_exit.Entity.PersonalEntity;
import com.example.entrance_exit.Model.Request.PersonalRequest;
import com.example.entrance_exit.Specification.PersonalSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalService {

    @Autowired
    private final com.example.entrance_exit.Repository.Personal personalRepository;

    public PersonalService(com.example.entrance_exit.Repository.Personal personalRepository){
        this.personalRepository = personalRepository;
    }

    public Page<PersonalEntity> getAllPeople(Pageable pageable, PersonalRequest personalRequest) {
        Specification<PersonalEntity> spec = Specification.where(PersonalSpecification.hasName(personalRequest.getName()).and(PersonalSpecification.hasRole(personalRequest.getRole())));

        if(personalRequest.getMinAge() != null && personalRequest.getMaxAge() != null){
            spec = spec.and(PersonalSpecification.hasAgeBetween(personalRequest.getMinAge(), personalRequest.getMaxAge()));
        }

        if(personalRequest == null){
            personalRepository.findAll(pageable);
        }
        return personalRepository.findAll(spec,pageable);
    }

    public Optional<PersonalEntity> getPerson(Long id){
        return personalRepository.findById(id);
    }

    public PersonalEntity createPersonal(PersonalEntity personal){
        return personalRepository.save(personal);
    }

    public PersonalEntity updatePersonal(Long id, PersonalEntity personal){
        Optional<PersonalEntity> existingPersonal = personalRepository.findById(id);

        if(existingPersonal.isPresent()){
            PersonalEntity existingPersonalOpt = existingPersonal.get();
            existingPersonalOpt.setName(personal.getName());
            existingPersonalOpt.setRole(personal.getRole());
            existingPersonalOpt.setAge(personal.getAge());
            existingPersonalOpt.setSurname(personal.getSurname());

            return personalRepository.save(existingPersonalOpt);

        } else {
            throw new RuntimeException("Personal not found with id: " + id);
        }

    }
}
