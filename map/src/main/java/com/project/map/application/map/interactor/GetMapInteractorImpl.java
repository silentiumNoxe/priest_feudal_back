package com.project.map.application.map.interactor;

import com.project.map.application.map.dto.GetMapDTO;
import com.project.map.application.map.exceptions.MapNotFoundException;
import com.project.map.application.map.interfaces.interactors.GetMapInteractor;
import com.project.map.application.map.interfaces.repositories.MapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@RequiredArgsConstructor
@Service
public class GetMapInteractorImpl implements GetMapInteractor {

    private final MapRepository mapRepository;

    @Override
    public GetMapDTO getByMapId(String id) {
        return mapRepository.getByMapId(id).orElseThrow(() -> new MapNotFoundException(""));
    }

}
