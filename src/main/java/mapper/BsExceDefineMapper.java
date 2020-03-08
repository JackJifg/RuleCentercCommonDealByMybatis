package mapper;

import entity.BsExceDefine;
import entity.Rule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BsExceDefineMapper {
    int deleteByPrimaryKey(String exceCode);

    int insert(BsExceDefine record);

    int insertSelective(BsExceDefine record);

    BsExceDefine selectByPrimaryKey(String exceCode);

    int updateByPrimaryKeySelective(BsExceDefine record);

    int updateByPrimaryKey(BsExceDefine record);

    List<BsExceDefine> getAll(@Param("idList") List<String> exceCodes);
}