package com.cibertec.service.impl;

import com.cibertec.models.Area;
import com.cibertec.repo.AreaRepo;
import com.cibertec.service.AreaService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaRepo areaRepo;

    @Override
    public List<Area> getAllAreas() {
        return areaRepo.findAll();
    }

    @Override
    public Area getAreaById(int id) {
        return areaRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Area not found"));
    }
    @Override
    public Area createArea(Area area) {
        return areaRepo.save(area);
    }

    @Override
    public Area updateArea(Area area) {
        return areaRepo.save(area);
    }

    @Override
    public void deleteArea(int id) {
        areaRepo.deleteById(id);
    }
}
