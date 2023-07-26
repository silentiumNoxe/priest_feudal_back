package com.priestfeudal.map.application.map.interactor;

import com.priestfeudal.map.application.map.dto.GetMapDTO;
import com.priestfeudal.map.application.map.exceptions.MapNotFoundException;
import com.priestfeudal.map.application.map.interfaces.interactors.GetMapInteractor;
import com.priestfeudal.map.application.map.interfaces.repositories.MapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class GetMapInteractorImpl implements GetMapInteractor {

    private final MapRepository mapRepository;

    @Override
    public GetMapDTO getByMapId(String id) {
        return mapRepository.getByMapId(id).orElseThrow(() -> new MapNotFoundException(""));
    }

}
