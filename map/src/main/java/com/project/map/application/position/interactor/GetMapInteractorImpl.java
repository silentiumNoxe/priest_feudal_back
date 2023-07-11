//package com.project.map.application.position.interactor;
//
//import com.project.map.application.map.interfaces.repositories.MapRepository;
//import com.project.map.application.position.dto.GetPositionDTO;
//import com.project.map.application.position.exceptions.PositionNotFoundException;
//import com.project.map.application.position.interfaces.GetMapInteractor;
//import lombok.RequiredArgsConstructor;
//
//
//@RequiredArgsConstructor
//public class GetMapInteractorImpl implements GetMapInteractor {
//
//    private final MapRepository mapRepository;
//
//    @Override
//    public GetPositionDTO getByMapId(String id) {
//        return
//    }
//
//    @Override
//    public GetPositionDTO getByIdentifier(String identifier) {
//        return mapRepository.findByIdentifier(identifier)
//                .map(modelDtoMapper::modelToDto)
//                .orElseThrow(() -> new PositionNotFoundException("not found"));
//    }
//
//}
