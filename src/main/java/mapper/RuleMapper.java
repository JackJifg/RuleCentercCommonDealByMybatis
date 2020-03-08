package mapper;

import entity.Rule;
import entity.Sence;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RuleMapper {
    int deleteByPrimaryKey(Long ruleId);

    int insert(Rule record);

    int insertSelective(Rule record);

    Rule selectByPrimaryKey(Long ruleId);

    int updateByPrimaryKeySelective(Rule record);

    int updateByPrimaryKey(Rule record);

    List<Rule> getAll(@Param("idList") List<Long> senceId);
}