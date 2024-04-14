package one.team.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import one.team.dto.OrderDto;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static OrderDto jsonToOrderDto(String json) {
        try {
            return objectMapper.readValue(json, OrderDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
