package com.example.entrance_exit.Controller;

import com.example.entrance_exit.Entity.GateEntity;
import com.example.entrance_exit.Service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gate")
public class GateController {

    @Autowired
    private final GateService gateService;

    public GateController(GateService gateService){
        this.gateService = gateService;
    }

    @GetMapping("/all")
    public List<GateEntity> getAllGates(){
        return gateService.getAllGate();
    }

    @GetMapping("/{gate_name}")
    public Optional<GateEntity> getGateByName(@PathVariable String gate_name){
        return gateService.getGateByName(gate_name);
    }

    @PostMapping("/create")
    public List<GateEntity> createGates(@RequestBody(required = false) List<GateEntity> gateList){
        return gateService.createGates(gateList);
    }

    @PutMapping("/update")
    public GateEntity updateGate(@RequestParam Long id,@RequestParam String gate_name){
        return gateService.updateGate(id,gate_name);
    }
}
