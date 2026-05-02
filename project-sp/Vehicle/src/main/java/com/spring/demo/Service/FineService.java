package com.spring.demo.Service;

import com.spring.demo.dto.FineCreateDto;
import com.spring.demo.dto.FineDto;
import com.spring.demo.dto.FineUpdateDto;

import java.util.List;

public interface FineService {
    FineDto createFine(Long vehicleId, FineCreateDto fineCreateDto);
    FineDto updateFine(Long id, FineUpdateDto fineUpdateDto);
    void deleteFine(Long id);
    FineDto getFineById(Long id);
    List<FineDto>getFinesByIds(List<Long>ids);
}
