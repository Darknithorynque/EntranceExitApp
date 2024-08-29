package com.example.entrance_exit.Controller;

import com.example.entrance_exit.Entity.PersonalEntity;
import com.example.entrance_exit.Model.Request.PersonalRequest;
import com.example.entrance_exit.Service.PersonalService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    private final PersonalService personalService;

    public PersonalController(PersonalService personalService){
        this.personalService = personalService;
    }

    @PostMapping("/all")
    public Page<PersonalEntity> getAllPeople(Pageable pageable, @RequestBody(required = false) @Nullable PersonalRequest personalRequest){
        return personalService.getAllPeople(pageable, personalRequest);
    }

    @GetMapping("/{id}")
    public Optional<PersonalEntity> getPerson(@PathVariable Long id){
        return personalService.getPerson(id);
    }

    @PostMapping("/create")
    public PersonalEntity createPersonal(@RequestBody PersonalEntity personal){
        return personalService.createPersonal(personal);
    }

    @PutMapping("/update")
    public PersonalEntity updatePersonal(Long id, @RequestBody PersonalEntity personal){
        return personalService.updatePersonal(id,personal);
    }
}
