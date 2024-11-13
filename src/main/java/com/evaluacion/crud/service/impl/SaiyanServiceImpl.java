package com.evaluacion.crud.service.impl;

import com.evaluacion.crud.dominio.entities.SaiyanEntity;
import com.evaluacion.crud.service.SaiyanService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class SaiyanServiceImpl implements SaiyanService {
    private long id=1L;
    private ArrayList<SaiyanEntity> saiyanEntities;

    public SaiyanServiceImpl() {
        this.saiyanEntities = new ArrayList<>();
        this.saiyanEntities.add(new SaiyanEntity(id, "Trunks", "SSJ","Multiples",8000.2f));
        id++;
    }
    public ArrayList<SaiyanEntity> sendError(){
        ArrayList<SaiyanEntity> empty = new ArrayList<SaiyanEntity>();
        empty.add(new SaiyanEntity(0,"La lista está vacia.","","",0));
        return empty;
    }
    @Override
    public String createSaiyan(SaiyanEntity saiyanEntity) {
        saiyanEntity.setId(id);
        id++;
        this.saiyanEntities.add(saiyanEntity);
        return "Saiyan Guardado";
    }

    @Override
    public ArrayList<SaiyanEntity> getAllSaiyan() {
        if(saiyanEntities.isEmpty()){
            return sendError();
        }
        return saiyanEntities;
    }

    @Override
    public ArrayList<Long> getIdSaiyan() {
        return new ArrayList<>(saiyanEntities.stream().map(SaiyanEntity::getId).toList());
    }

    @Override
    public ArrayList<Object> getNombreSaiyan() {
        return new ArrayList<>(saiyanEntities.stream().map(SaiyanEntity::getNombre).toList());
    }

    @Override
    public Optional<SaiyanEntity> getSaiyanById(long id) {
        return saiyanEntities.stream().filter(e -> e.getId()==id).findFirst();
    }

    @Override
    public ArrayList<Long> getSaiyanId() {
        return new ArrayList<>(saiyanEntities.stream().map(SaiyanEntity::getId).toList());
    }

    @Override
    public String deleteSaiyan(long id) {
        Optional<SaiyanEntity> query = this.getSaiyanById(id);
        if(query.isEmpty()){
            return "Saiyan No encontrado";
        }else{
            saiyanEntities = new ArrayList<>(saiyanEntities.stream().filter(e -> !(e.getId()==id)).toList());
            return "Saiyan Eliminado";
        }
    }

    @Override
    public Optional<SaiyanEntity> updateSaiyan(long id, SaiyanEntity saiyanEntity) {
        Optional<SaiyanEntity> query = this.getSaiyanById(id);
        if(query.isEmpty()){
            return query;
        }
        SaiyanEntity saiyan = query.get();
        saiyan.setNombre(saiyanEntity.getNombre());
        saiyan.setFase(saiyanEntity.getFase());
        saiyan.setArteMarcial(saiyanEntity.getArteMarcial());
        saiyan.setPoder(saiyanEntity.getPoder());
        return query;
    }

}
