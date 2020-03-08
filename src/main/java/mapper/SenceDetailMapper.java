package mapper;

import entity.SenceDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SenceDetailMapper {
    int deleteByPrimaryKey(Long detailId);

    int insert(SenceDetail record);

    int insertSelective(SenceDetail record);

    SenceDetail selectByPrimaryKey(Long detailId);

    int updateByPrimaryKeySelective(SenceDetail record);

    int updateByPrimaryKey(SenceDetail record);

    List<SenceDetail> getAll(@Param("idList") List<Long> senceId);

    int addSenceDetail(SenceDetail record);


}