package com.example.entrance_exit.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "entrance_exit_record")
public class EntranceExitRecordEntity {
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public PersonalEntity getPersonal() {
        return personal;
    }

    public void setPersonal(PersonalEntity personal) {
        this.personal = personal;
    }

    public GateEntity getGate() {
        return gate;
    }

    public void setGate(GateEntity gate) {
        this.gate = gate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "personal_id")
    private PersonalEntity personal;
    @ManyToOne
    @JoinColumn(name = "gate_id")
    private GateEntity gate;
    private boolean status;
    private Date date;

}
