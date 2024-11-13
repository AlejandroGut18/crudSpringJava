package com.evaluacion.crud.service;

import com.evaluacion.crud.dominio.entities.SaiyanEntity;

import java.util.ArrayList;
import java.util.Optional;

public interface SaiyanService {
    public String createSaiyan(SaiyanEntity saiyanEntity);
    public ArrayList<SaiyanEntity> getAllSaiyan();
    public ArrayList<Long> getIdSaiyan();
    public ArrayList<Object> getNombreSaiyan();
    public ArrayList<Long> getSaiyanId();

    public Optional<SaiyanEntity> getSaiyanById(long id);

    public String deleteSaiyan(long id);
    public Optional<SaiyanEntity> updateSaiyan(long id, SaiyanEntity saiyanEntity);
}
