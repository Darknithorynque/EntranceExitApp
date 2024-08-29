package com.example.entrance_exit.Service;

import com.example.entrance_exit.Entity.EntranceExitRecordEntity;
import com.example.entrance_exit.Model.Request.EntranceExitRecordRequest;
import com.example.entrance_exit.Repository.EntranceExitRecod;
import com.example.entrance_exit.Specification.EntranceExitRecordSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntranceExitRecordService {

    @Autowired
    private final EntranceExitRecod entranceExitRecodRepository;

    public EntranceExitRecordService(EntranceExitRecod entranceExitRecodRepository) {
        this.entranceExitRecodRepository = entranceExitRecodRepository;
    }

    public Page<EntranceExitRecordEntity> getAllRecords(Pageable pageable, EntranceExitRecordRequest entranceExitRecordRequest){

        Specification<EntranceExitRecordEntity> spec = Specification.where(EntranceExitRecordSpecification.hasStatus(entranceExitRecordRequest.getStatus()).and(EntranceExitRecordSpecification.hasPersonalId(entranceExitRecordRequest.getPid())).and(EntranceExitRecordSpecification.hasPersonalName(entranceExitRecordRequest.getPersonalName())));

        if (entranceExitRecordRequest.getStartDate() != null && entranceExitRecordRequest.getEndDate() != null){
            spec = spec.and(EntranceExitRecordSpecification.betweenDate(entranceExitRecordRequest.getStartDate(),entranceExitRecordRequest.getEndDate()));
        }

        return entranceExitRecodRepository.findAll(spec,pageable);
    }

    public Optional<EntranceExitRecordEntity> getRecordById(Long id){
        return entranceExitRecodRepository.findById(id);
    }

    public EntranceExitRecordEntity createRecord(EntranceExitRecordEntity entranceExitRecord){
        return entranceExitRecodRepository.save(entranceExitRecord);
    }

    public EntranceExitRecordEntity updateRecord(EntranceExitRecordEntity entranceExitRecord){
        Optional<EntranceExitRecordEntity> existingRecord = entranceExitRecodRepository.findById(entranceExitRecord.getId());

        if (existingRecord.isPresent() && existingRecord != null){
            EntranceExitRecordEntity existingRecordOpt = existingRecord.get();

            existingRecordOpt.setDate(entranceExitRecord.getDate());
            existingRecordOpt.setPersonal(entranceExitRecord.getPersonal());
            existingRecordOpt.setStatus(entranceExitRecord.isStatus());
            existingRecordOpt.setGate(entranceExitRecord.getGate());

            return entranceExitRecodRepository.save(existingRecordOpt);
        } else {
            throw new RuntimeException("could not find a record with id "+entranceExitRecord.getId());
        }
    }
}
