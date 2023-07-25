package com.priestfeudal.map.application.map.interactor;

import com.priestfeudal.map.application.map.dto.GetMapDTO;
import com.priestfeudal.map.domain.entity.map.Map;
import com.priestfeudal.map.application.map.dto.CreateMapDTO;
import com.priestfeudal.map.application.map.interfaces.interactors.CreateMapInteractor;
import com.priestfeudal.map.application.map.interfaces.repositories.MapRepository;
import com.priestfeudal.map.domain.entity.map.methods.MapCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateMapInteractorImpl implements CreateMapInteractor {

    private final MapCreate createMethod;
    private final MapRepository mapRepository;

    @Override
    public GetMapDTO create(CreateMapDTO dto) {
        Map map = createMethod.create(dto.getName(), dto.getX(), dto.getY(), dto.getZ());
        return mapRepository.createMap(map);
    }
}
