package one.team.mapper;

import one.team.dto.NewOrderDTO;
import one.team.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order orderDTOToOrder(NewOrderDTO orderDTO);
}
