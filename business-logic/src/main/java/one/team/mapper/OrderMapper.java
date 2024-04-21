package one.team.mapper;

import one.team.dto.OrderDTO;
import one.team.entity.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    Order orderDTOToOrder(OrderDTO orderDTO);
}
