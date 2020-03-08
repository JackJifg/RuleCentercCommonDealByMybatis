package Tools;

import entity.Rule;
import entity.Sence;
import entity.SenceRuleRel;
import mapper.SenceRuleRelMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: SenceTools
 * @description: 规则ID:
 * @author: ouyangcl
 * @create: 2019-06-11 15:50
 **/
public class SencerRuleRellTools {

    static SqlSession session = DBTools.getSession();
    static mapper.SenceRuleRelMapper senceRuleRelMapper = session.getMapper(mapper.SenceRuleRelMapper.class);


    public static List<SenceRuleRel> getAll(List<Long> senceIds) {
        List<SenceRuleRel> senceRuleRelList = senceRuleRelMapper.getAll(senceIds);
        return senceRuleRelList;
    }


    public static List<Long> getAllRuleIds(List<Long> senceIds) {
        List<SenceRuleRel> senceRuleRelList = senceRuleRelMapper.getAll(senceIds);
        List<Long> ruleIds = new ArrayList<>();
        for (int i = 0; senceRuleRelList != null && i < senceRuleRelList.size(); i++) {
            ruleIds.add(senceRuleRelList.get(i).getRuleId());
        }
        return ruleIds;
    }

    public static String dbString(List<Long> senceIds) {
        List<SenceRuleRel> senceRuleRelList = senceRuleRelMapper.getAll(senceIds);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("--------------场景规则关联----").append(senceRuleRelList.size()).append("---条\n");
        for (int i = 0; senceRuleRelList.size() > 0 && i < senceRuleRelList.size(); i++) {
            String deleString = "delete from base_rule.rf_sence_rule_rel where  SENCE_ID = " + senceRuleRelList.get(i).getSenceId() + " and RULE_ID = " + senceRuleRelList.get(i).getRuleId() + ";";
            String insertString = "insert into base_rule.rf_sence_rule_rel (REL_ID, SENCE_ID, RULE_ID, EXT_TYPE, NOTES, STATE, REMARKS)\n" +
                    "values (" + senceRuleRelList.get(i).getRelId() + ", " + senceRuleRelList.get(i).getSenceId() + ", " + senceRuleRelList.get(i).getRuleId() + ", null, '" + senceRuleRelList.get(i).getNotes() + "', '" + senceRuleRelList.get(i).getState() + "', '" + senceRuleRelList.get(i).getRemarks() + "');";
            stringBuffer.append(deleString).append("\n").append(insertString).append("\n").append("\n");
        }
        return stringBuffer.toString();
    }

    public static String addSenceRuleRel(Sence sence, String ruleIdS) {
        SqlSession sqlSession = DBTools.getSession();
        List<Long> senceIds = new ArrayList<>();
        senceIds.add(sence.getSenceId());
        List<SenceRuleRel> senceRuleRelList = senceRuleRelMapper.getAll(senceIds);
        SenceRuleRel preSenceRuleRel = senceRuleRelList.get(0);
        List<Long> ruleIds = CommonUtils.formatSenceIds(ruleIdS);
        List<Rule> rules = RuleTools.getAll(ruleIds);
        senceIds.clear();
        senceIds.add(sence.getSenceId()+1);
        Sence newSence = SenceTools.getAll(senceIds).get(0);
        try {
            for (int i = 0; i < rules.size(); i++) {
                SenceRuleRel senceRuleRel = new SenceRuleRel(preSenceRuleRel.getRelId() + 1+i, rules.get(i), newSence, preSenceRuleRel);
                System.out.println(senceRuleRel.toString());
                sqlSession.insert("addSenceRuleRel", senceRuleRel);
            }
            sqlSession.commit();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            sqlSession.close();
            return null;
        }

    }

}
