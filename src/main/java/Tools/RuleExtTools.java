package Tools;

import entity.RuleExt;
import mapper.RuleExtMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @className: RuleExtTools
 * @description: 警告规则工具类
 * @author: ouyangcl
 * @create: 2019-06-13 16:38
 **/
public class RuleExtTools {


    static SqlSession session = DBTools.getSession();
    static RuleExtMapper ruleExtMapper = session.getMapper(RuleExtMapper.class);


    public static List<RuleExt> getAll(List<Long> extIds) {
        List<RuleExt> ruleExtList = ruleExtMapper.getAll(extIds);
        return ruleExtList;
    }


    public static String dbString(List<Long> extIds) {
        List<RuleExt> ruleExtList = ruleExtMapper.getAll(extIds);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("--------------警告规则------------").append(ruleExtList.size()).append("---条\n");
        for (int i = 0; ruleExtList.size() > 0 && i < ruleExtList.size(); i++) {
            String deleString = "delete from base_rule.rf_rule_ext where EXT_ID = " + ruleExtList.get(i).getExtId() + " and RULE_ID = " + ruleExtList.get(i).getRuleId() + ";";
            String insertString = "insert into base_rule.rf_rule_ext (EXT_ID, RULE_ID, CODE, CODE_DESC, VAL, VAL_DESC, NOTES, STATE, REMARKS, EXT_A, EXT_B, EXT_C)\n" +
                    "values (" + ruleExtList.get(i).getExtId() + ", " + ruleExtList.get(i).getRuleId() + ", '" + ruleExtList.get(i).getCode() + "', '" + ruleExtList.get(i).getCodeDesc() + "', '" + ruleExtList.get(i).getVal() + "', '" + ruleExtList.get(i).getValDesc() + "', '" + ruleExtList.get(i).getNotes() + "', '" + ruleExtList.get(i).getState() + "', '" + ruleExtList.get(i).getRemarks() + "', '" + ruleExtList.get(i).getExtA() + "', '" + ruleExtList.get(i).getExtB() + "', '" + ruleExtList.get(i).getExtC() + "');\n";
            stringBuffer.append(deleString).append("\n").append(insertString).append("\n").append("\n");
        }
        return stringBuffer.toString().replaceAll("'null'", "" + null + "");
    }

    public static String senceRuleExtDbString(List<Long> ruleIds, String val) {
        List<RuleExt> ruleExtList = ruleExtMapper.getAllBySenceIds(ruleIds, val);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("--------------警告规则------------").append(ruleExtList.size()).append("---条\n");
        for (int i = 0; ruleExtList.size() > 0 && i < ruleExtList.size(); i++) {
            String deleString = "delete from base_rule.rf_rule_ext where EXT_ID = " + ruleExtList.get(i).getExtId() + " and RULE_ID = " + ruleExtList.get(i).getRuleId() + ";";
            String insertString = "insert into base_rule.rf_rule_ext (EXT_ID, RULE_ID, CODE, CODE_DESC, VAL, VAL_DESC, NOTES, STATE, REMARKS, EXT_A, EXT_B, EXT_C)\n" +
                    "values (" + ruleExtList.get(i).getExtId() + ", " + ruleExtList.get(i).getRuleId() + ", '" + ruleExtList.get(i).getCode() + "', '" + ruleExtList.get(i).getCodeDesc() + "', '" + ruleExtList.get(i).getVal() + "', '" + ruleExtList.get(i).getValDesc() + "', '" + ruleExtList.get(i).getNotes() + "', '" + ruleExtList.get(i).getState() + "', '" + ruleExtList.get(i).getRemarks() + "', '" + ruleExtList.get(i).getExtA() + "', '" + ruleExtList.get(i).getExtB() + "', '" + ruleExtList.get(i).getExtC() + "');\n";
            stringBuffer.append(deleString).append("\n").append(insertString).append("\n").append("\n");
        }
        return stringBuffer.toString().replaceAll("'null'", "" + null + "");
    }

    public static String getSenceRuleExtString(String senceIdString, String val) {
        List<Long> senceIds = CommonUtils.formatSenceIds(senceIdString);
        List<Long> ruleIds = SencerRuleRellTools.getAllRuleIds(senceIds);
        return RuleExtTools.senceRuleExtDbString(ruleIds, val);
    }
}
