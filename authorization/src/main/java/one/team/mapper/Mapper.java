package one.team.mapper;

public interface Mapper<DTO, DAO> {
    DTO daoToDto(DAO dao);

    DAO dtoToDao(DTO dto);
}
