package Tools;

import entity.Sence;
import entity.SenceDetail;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @className: CommonUtils
 * @description: 公共工具类
 * @author: ouyangcl
 * @create: 2019-06-12 10:38
 **/
public class CommonUtils {
    static SqlSession session = DBTools.getSession();
    static mapper.SenceMapper senceMapper = session.getMapper(mapper.SenceMapper.class);

    public  static void getAllSenceDbString(String senceIdString) throws Exception{
        List<Long> senceIdList = formatSenceIds(senceIdString);
        StringBuffer db = new StringBuffer();
        db.append(SenceTools.dbString(senceIdList));
        db.append(SenceDetailTools.dbString(senceIdList));
        db.append(SencerRuleRellTools.dbString(senceIdList));
        db.append(RuleTools.senceRulesDbString(senceIdList));
        OutTools.outPut(db.toString());
        System.out.println("场景db导出完毕！");
    }
    public  static void getAllExceCodeDbString(String exceCodeString) throws Exception{
        List<String> exceCodeList = formatExceCodeIds(exceCodeString);
        StringBuffer db = new StringBuffer();
        db.append(BsExceDefineTools.dbString(exceCodeList));
        OutTools.outPut(db.toString());
        System.out.println("规则提示语导出完毕！");
    }

    public static List<Long> formatSenceIds(String senceIdString){

        String[] senceIds = senceIdString.split(",");
        List<Long> senceIdList = new ArrayList<>();
        for (int i = 0; null != senceIds &&i <senceIds.length ; i++) {
            senceIdList.add(Long.parseLong(senceIds[i]));
        }
        return  senceIdList;
    }

    public static List<String> formatExceCodeIds(String exceCodeString){

        String[] exceCodeIds = exceCodeString.split(",");
        List<String> exceCodeList = new ArrayList<>();
        for (int i = 0; null != exceCodeIds &&i <exceCodeIds.length ; i++) {
            exceCodeList.add(exceCodeIds[i]);
        }
        return  exceCodeList;
    }

    public  static void getRuleDbString(String ruleIes) throws Exception{
        List<Long> ruleList = formatSenceIds(ruleIes);
        StringBuffer db = new StringBuffer();
        db.append(RuleTools.dbString(ruleList));
        OutTools.outPut(db.toString());
        System.out.println("规则出完毕！");
    }

    public  static void getRuleExtDbString(String ruleExtCodes) throws Exception{
        List<Long> ruleExtCodeList = formatSenceIds(ruleExtCodes);
        StringBuffer db = new StringBuffer();
        db.append(RuleExtTools.dbString(ruleExtCodeList));
        OutTools.outPut(db.toString());
        System.out.println("警告规则出完毕！");
    }

    public  static void getAllSenceAndRuleExtDbString(String senceIdString,String val) throws Exception{
        List<Long> senceIdList = formatSenceIds(senceIdString);
        StringBuffer db = new StringBuffer();
        db.append(SenceTools.dbString(senceIdList));
        db.append(SenceDetailTools.dbString(senceIdList));
        db.append(SencerRuleRellTools.dbString(senceIdList));
        db.append(RuleTools.senceRulesDbString(senceIdList));
        db.append(RuleExtTools.getSenceRuleExtString(senceIdString,val));
        OutTools.outPut(db.toString());
        System.out.println("场景db,警告db导出完毕！");
    }

    public static  String addSence(String senceName, Map value,String ruleIds){
        String newSence = "";
       try{
           Sence preSence = senceMapper.getPreSence();
           //插入sence表
           SenceTools.addSence(senceName);
           List senceids = new ArrayList();
           senceids.add(preSence.getSenceId());
           List<SenceDetail> senceDetailList = SenceDetailTools.getAll(senceids);
           //插入senceDetail表
           SenceDetailTools.addSenceDetail(preSence.getSenceId(), senceDetailList.get(0).getDetailId(), senceDetailList.get(0), value);
           //插入senceRuleRel表
           SencerRuleRellTools.addSenceRuleRel(preSence, ruleIds);
           newSence =  preSence.getSenceId()+1+"";
       }catch (Exception e){
           System.out.println(e);
       }
        return newSence;
    }

}
