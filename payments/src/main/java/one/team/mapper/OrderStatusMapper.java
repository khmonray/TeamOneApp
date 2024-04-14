package one.team.mapper;

import one.team.dto.OrderStatusDto;
import one.team.model.OrderStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderStatusMapper {

    OrderStatusMapper INSTANCE = Mappers.getMapper(OrderStatusMapper.class);

    OrderStatusDto toDto(OrderStatus orderStatus);
}
