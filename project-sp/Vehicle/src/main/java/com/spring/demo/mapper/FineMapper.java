package com.spring.demo.mapper;

import com.spring.demo.dto.FineDto;
import com.spring.demo.model.Fine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
//خلّي MapStruct يحوّل الـ interface ده إلى Spring Bean
//علشان ي عمده اقدر استخدمة لما اجى اعمل injcit داخلservice (@Autowired)
@Mapper(componentModel="spring")
public interface FineMapper {
   @Mapping(source = "vehicle.id",target = "vehicleId")
    FineDto toDto(Fine fine);
    Fine toEntity(FineDto fineDto);
    List<FineDto> toDtoList(List<Fine> fines);
    List<Fine> toEntityList(List<FineDto>dtoList);
}

