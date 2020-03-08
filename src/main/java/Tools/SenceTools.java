package Tools;

import entity.Sence;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @className: SenceTools
 * @description: 规则ID:
 * @author: ouyangcl
 * @create: 2019-06-11 15:50
 **/
public class SenceTools {

    static SqlSession session = DBTools.getSession();
    static mapper.SenceMapper senceMapper = session.getMapper(mapper.SenceMapper.class);


    public static List<Sence> getAll(List<Long> senceIds) {
        List<Sence> senceList = senceMapper.getAll(senceIds);
        return senceList;
    }

    public  static Sence getMaxSence(){
        return senceMapper.getPreSence();
    }

    public static String dbString(List<Long> senceIds) {
        List<Sence> senceList = SenceTools.getAll(senceIds);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("--------------场景------------").append(senceList.size()).append("---条\n");
        for (int i = 0; senceList.size() > 0 && i < senceList.size(); i++) {
            String deleString = "delete from base_rule.rf_sence where sence_id = "+senceList.get(i).getSenceId()+ " and sence_code = '"+senceList.get(i).getSenceCode()+"';";
            String insertString = "insert into base_rule.rf_sence (SENCE_ID, TENANT_ID, BASE_ID, CATALOG_ID, SENCE_CODE, SENCE_NAME, SENCE_DESC, PRIORITY, NOTES, STATE, REMARKS)\n" +
                    "values ("+senceList.get(i).getSenceId()+", "+senceList.get(i).getTenantId()+", "+senceList.get(i).getBaseId()+", "+senceList.get(i).getCatalogId()+", '"+senceList.get(i).getSenceCode()+"', '"+senceList.get(i).getSenceName()+"', '"+senceList.get(i).getSenceDesc()+"', null, null, '"+senceList.get(i).getState()+"', '"+senceList.get(i).getRemarks()+"');";
            stringBuffer.append(deleString).append("\n").append(insertString).append("\n").append("\n");
        }
        return stringBuffer.toString();
    }

    public static String addSence(String senceName){
        Sence preSence = senceMapper.getPreSence();
        Sence sence = new Sence(preSence,senceName);
        SqlSession sqlSession = DBTools.getSession();
        String result = "";
        try {
            sqlSession.insert("addSence", sence);
            sqlSession.commit();
            result = "insertSenceSuccess"+sence.getSenceId();
            System.out.println(sence.toString());
        }catch (Exception e){
            result = "insertSencefalse"+sence.getSenceId();
            System.out.println(e);
        }finally {
            sqlSession.close();
            return  result;
        }
    }

}
