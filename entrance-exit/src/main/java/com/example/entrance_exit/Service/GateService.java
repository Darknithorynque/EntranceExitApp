package com.example.entrance_exit.Service;

import com.example.entrance_exit.Entity.GateEntity;
import com.example.entrance_exit.Repository.Gate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GateService {

    @Autowired
    private final Gate gateRepository;

    public GateService(Gate gateRepository){
        this.gateRepository = gateRepository;
    }

    public List<GateEntity> getAllGate(){
        return gateRepository.findAll();
    }

    public Optional<GateEntity> getGateByName(String gate_name){
        return gateRepository.findByGateName(gate_name);
    }

    public List<GateEntity> createGates(List<GateEntity> gateList){
        return gateRepository.saveAll(gateList);
    }

    public GateEntity updateGate(Long id, String gate_name){
        Optional<GateEntity> existingGateOpt = gateRepository.findById(id);

        if (existingGateOpt.isPresent() && existingGateOpt != null){
            GateEntity existingGate = existingGateOpt.get();
            existingGate.setGateName(gate_name);
            return gateRepository.save(existingGate);
        } else {
            throw new RuntimeException("Personal not found with id: " + id);
        }

    }
}
