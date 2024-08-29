package com.example.entrance_exit.Controller;

import com.example.entrance_exit.Entity.EntranceExitRecordEntity;
import com.example.entrance_exit.Model.Request.EntranceExitRecordRequest;
import com.example.entrance_exit.Service.EntranceExitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/entrance-exit-record")
public class EntranceExitRecordController {

    @Autowired
    private final EntranceExitRecordService entranceExitRecordService;

    public EntranceExitRecordController(EntranceExitRecordService entranceExitRecordService){
        this.entranceExitRecordService = entranceExitRecordService;
    }

    @PostMapping("/all")
    public Page<EntranceExitRecordEntity> getAllEntranceExitRecord(Pageable pageable, @RequestBody EntranceExitRecordRequest entranceExitRecordRequest){

        return entranceExitRecordService.getAllRecords(pageable, entranceExitRecordRequest);
    }

    @PostMapping("/create")
    public EntranceExitRecordEntity createEntranceRecord(@RequestBody EntranceExitRecordEntity entranceExitRecord){
        return entranceExitRecordService.createRecord(entranceExitRecord);
    }

    @PutMapping("/update")
    public EntranceExitRecordEntity updateEntranceRecord(@RequestBody EntranceExitRecordEntity entranceExitRecord){
        return entranceExitRecordService.updateRecord(entranceExitRecord);
    }

    @GetMapping("/{id}")
    public Optional<EntranceExitRecordEntity> getEntranceExitRecordById(@PathVariable Long id){
        return entranceExitRecordService.getRecordById(id);
    }
}
