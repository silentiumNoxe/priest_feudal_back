package com.project.map.application.map.interactor;

import com.project.map.application.map.dto.GetMapDTO;
import com.project.map.application.map.dto.UpdateMapDTO;
import com.project.map.application.map.interfaces.interactors.UpdateMapInteractor;
import com.project.map.application.map.interfaces.repositories.MapRepository;
import com.project.map.domain.entity.map.Map;
import com.project.map.domain.entity.map.methods.MapUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UpdateMapInteractorImpl implements UpdateMapInteractor {

    private final MapUpdate updateMethod;
    private final MapRepository mapRepository;

    @Override
    public GetMapDTO update(UpdateMapDTO dto) {
        Map map = updateMethod.update(UUID.fromString(dto.getId()),
                dto.getName(), dto.getX(), dto.getY(), dto.getZ());
        return mapRepository.updateMap(map);
    }
}
