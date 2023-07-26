package com.priestfeudal.map.presentation.api.controller;

import com.priestfeudal.map.application.map.dto.UpdateMapDTO;
import com.priestfeudal.map.application.map.interfaces.interactors.GetMapInteractor;
import com.priestfeudal.map.application.map.interfaces.interactors.UpdateMapInteractor;
import com.priestfeudal.map.application.map.dto.CreateMapDTO;
import com.priestfeudal.map.application.map.dto.GetMapDTO;
import com.priestfeudal.map.application.map.interfaces.interactors.CreateMapInteractor;
import com.priestfeudal.map.presentation.api.dto.ApiResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/map")
@RequiredArgsConstructor
public class MapController {

    private final CreateMapInteractor createMapInteractor;
    private final UpdateMapInteractor updateMapInteractor;
    private final GetMapInteractor getMapInteractor;

    @PostMapping
    public ResponseEntity<ApiResponse<GetMapDTO>> create(@RequestBody CreateMapDTO request) {
        GetMapDTO response = createMapInteractor.create(request);
        return ResponseEntity
                .status(201)
                .body(new ApiResponse<>(ApiResponse.Message.SUCCESS, response));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<GetMapDTO>> update(@RequestBody UpdateMapDTO request) {
        GetMapDTO response = updateMapInteractor.update(request);
        return ResponseEntity
               .status(201)
               .body(new ApiResponse<>(ApiResponse.Message.SUCCESS, response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetMapDTO>> getById(@PathVariable String id) {
        GetMapDTO response = getMapInteractor.getByMapId(id);
        return ResponseEntity
                .status(200)
                .body(new ApiResponse<>(ApiResponse.Message.SUCCESS, response));
    }


//    public ResponseEntity<ApiResponse<CommandResponse>> deleteById
}
