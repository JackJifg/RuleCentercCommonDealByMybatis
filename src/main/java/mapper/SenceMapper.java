package mapper;

import entity.Sence;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SenceMapper {
    int deleteByPrimaryKey(Long senceId);

    int addSence(Sence record);

    int insertSelective(Sence record);

    Sence selectByPrimaryKey(Long senceId);

    int updateByPrimaryKeySelective(Sence record);

    int updateByPrimaryKey(Sence record);

    List<Sence> getAll(@Param("idList") List<Long> senceId);

    Sence getPreSence();
}