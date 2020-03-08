package mapper;

import entity.RuleExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RuleExtMapper {
    int deleteByPrimaryKey(Long extId);

    int insert(RuleExt record);

    int insertSelective(RuleExt record);

    RuleExt selectByPrimaryKey(Long extId);

    int updateByPrimaryKeySelective(RuleExt record);

    int updateByPrimaryKey(RuleExt record);

    List<RuleExt> getAll(@Param("idList") List<Long> extIds);

    List<RuleExt> getAllBySenceIds(@Param("idList") List<Long> ruleIds ,@Param("val") String val);
}