package Tools;

import entity.Rule;
import entity.SenceRuleRel;
import mapper.RuleMapper;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @className: SenceTools
 * @description: 规则ID:
 * @author: ouyangcl
 * @create: 2019-06-11 15:50
 **/
public class RuleTools {

    static SqlSession session = DBTools.getSession();
    static RuleMapper ruleMapper = session.getMapper(RuleMapper.class);


    public static List<Rule> getAll(List<Long> ruleIds) {
        List<Rule> ruleList = ruleMapper.getAll(ruleIds);
        return ruleList;
    }


    public static String dbString(List<Long> ruleIds) {
        List<Rule> ruleList = ruleMapper.getAll(ruleIds);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("--------------规则------------").append(ruleList.size()).append("---条\n");
        for (int i = 0; ruleList.size() > 0 && i < ruleList.size(); i++) {
            String deleString = "delete from base_rule.rf_rule a where a.rule_id = " + ruleList.get(i).getRuleId() + " and rule_code = '" + ruleList.get(i).getRuleCode() + "';";
            String insertString = "insert into base_rule.rf_rule (RULE_ID, CATALOG_ID, RULE_CODE, RULE_NAME, RULE_TYPE, CONTENT1, CONTENT3, CONTENT2, RULE_DESC1, RULE_DESC2, RULE_DESC3, PRIORITY, NOTES, STATE, EFFECT_TIME, EXPIRE_TIME, REMARKS)\n" +
                    "values (" + ruleList.get(i).getRuleId() + ", " + ruleList.get(i).getCatalogId() + ", '" + ruleList.get(i).getRuleCode() + "', '" + ruleList.get(i).getRuleName() + "', '" + ruleList.get(i).getRuleType() + "', '" + ruleList.get(i).getContent1() + "', '" + ruleList.get(i).getContent3() + "', '" + ruleList.get(i).getContent2() + "', '" + ruleList.get(i).getRuleDesc1() + "', '" + ruleList.get(i).getRuleDesc2() + "', '" + ruleList.get(i).getRuleDesc3() + "','" + ruleList.get(i).getPriority() + "', '" + ruleList.get(i).getNotes() + "', '" + ruleList.get(i).getState() + "', to_date('" + formatDate(ruleList.get(i).getEffectTime()) + "', 'dd-mm-yyyy hh24:mi:ss'), to_date('" + formatDate(ruleList.get(i).getExpireTime()) + "', 'dd-mm-yyyy hh24:mi:ss'), '" + ruleList.get(i).getRemarks() + "');";
            stringBuffer.append(deleString).append("\n").append(insertString).append("\n").append("\n");
        }
        return stringBuffer.toString().replaceAll("'null'",""+null+"");
    }


    public static String senceRulesDbString(List<Long> senceIds) {
        List<Long> ruleIds = SencerRuleRellTools.getAllRuleIds(senceIds);
        return dbString(ruleIds);
    }

    public static String formatDate(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sf.format(date);
    }

}
