package com.cibertec.service;

import com.cibertec.models.Area;

import java.util.List;

public interface AreaService {

    public List<Area> getAllAreas();

    public Area getAreaById(int id);

    public Area createArea(Area area);

    public Area updateArea(Area area);

    public void deleteArea(int id);
}


