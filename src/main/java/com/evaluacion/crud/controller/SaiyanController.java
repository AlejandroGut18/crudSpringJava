package com.evaluacion.crud.controller;

import com.evaluacion.crud.dominio.entities.SaiyanEntity;
import com.evaluacion.crud.service.SaiyanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/saiyans")
public class SaiyanController {
    private SaiyanService saiyanService;

    @Autowired
    public SaiyanController(SaiyanService saiyanService){
        this.saiyanService = saiyanService;
    }

    @GetMapping("/all")
    public ArrayList<SaiyanEntity> getAllSaiyan(){
        return saiyanService.getAllSaiyan();
    }

    @GetMapping("/id")
    public ArrayList<Long> getIdSaiyan(){
        return saiyanService.getSaiyanId();
    }

    @GetMapping("/nombre")
    public ArrayList<Object> getNombreSaiyan(){
        return saiyanService.getNombreSaiyan();
    }

    @PostMapping
    public String createSaiyan(@RequestBody SaiyanEntity saiyanEntity){
        return saiyanService.createSaiyan(saiyanEntity);
    }

    @PutMapping("/{id}")
    public String updateSaiyan(@RequestBody SaiyanEntity saiyanEntity, @PathVariable long id){
        saiyanService.updateSaiyan(id,saiyanEntity);
        return "Saiyan Actualizado";
    }

    @DeleteMapping("/{id}")
    public String deleteSaiyan(@PathVariable long id){
        return saiyanService.deleteSaiyan(id);
    }

}
