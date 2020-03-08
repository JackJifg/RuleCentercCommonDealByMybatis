package mapper;

import entity.SenceDetail;
import entity.SenceRuleRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SenceRuleRelMapper {
    int deleteByPrimaryKey(Long relId);

    int addSenceRuleRel(SenceRuleRel record);

    int insertSelective(SenceRuleRel record);

    SenceRuleRel selectByPrimaryKey(Long relId);

    int updateByPrimaryKeySelective(SenceRuleRel record);

    int updateByPrimaryKey(SenceRuleRel record);

    List<SenceRuleRel> getAll(@Param("idList") List<Long> senceId);
}