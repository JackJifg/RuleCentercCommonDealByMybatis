package Tools;

import entity.Sence;
import entity.SenceDetail;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @className: SenceTools
 * @description: 规则ID:
 * @author: ouyangcl
 * @create: 2019-06-11 15:50
 **/
public class SenceDetailTools {

    static SqlSession session = DBTools.getSession();
    static mapper.SenceDetailMapper senceDetailMapper = session.getMapper(mapper.SenceDetailMapper.class);


    public static List<SenceDetail> getAll(List<Long> senceIds) {
        List<SenceDetail> senceDetailsList = senceDetailMapper.getAll(senceIds);
        return senceDetailsList;
    }


    public static String dbString(List<Long> senceIds) {
        List<SenceDetail> senceDetailsList = SenceDetailTools.getAll(senceIds);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("--------------场景明细------------").append(senceDetailsList.size()).append("---条\n");
        for (int i = 0; senceDetailsList.size() > 0 && i < senceDetailsList.size(); i++) {
            String deleString = "delete from base_rule.rf_sence_detail where detail_id = "+senceDetailsList.get(i).getDetailId()+ " and sence_id = "+senceDetailsList.get(i).getSenceId()+";";
            String insertString = "insert into base_rule.rf_sence_detail (DETAIL_ID, SENCE_ID, FETURE_ID, OP, VALUE1, VALUE1_DESC, VALUE2, VALUE2_DESC, VALUE3, VALUE3_DESC, NOTES, STATE, REMARKS)\n" +
                    "values ("+senceDetailsList.get(i).getDetailId()+", "+senceDetailsList.get(i).getSenceId()+", "+senceDetailsList.get(i).getFetureId()+", '"+senceDetailsList.get(i).getOp()+"', '"+senceDetailsList.get(i).getValue1()+"', null, null, null, null, null, null, '"+senceDetailsList.get(i).getState()+"', '"+senceDetailsList.get(i).getRemarks()+"');";
            stringBuffer.append(deleString).append("\n").append(insertString).append("\n").append("\n");
        }
        return stringBuffer.toString();
    }

    public static String addSenceDetail(long senceId, long detailId ,SenceDetail preSenceDetail, Map value){
        SqlSession sqlSession =DBTools.getSession();
        String result = "";
        Set set = value.keySet();
        List<String> keyList = new ArrayList<String>();
        for (Object key : set) {
            keyList.add(String.valueOf(key));
        }
       try {
           for (int i = 0; i <value.size() ; i++) {
               SenceDetail senceDetail = new SenceDetail(senceId +1,preSenceDetail,detailId+1+i,keyList.get(i),String.valueOf(value.get(Long.parseLong(keyList.get(i)))));
               sqlSession.insert("addSenceDetail", senceDetail);
               System.out.println(senceDetail.toString());
           }
           sqlSession.commit();
           result = "inSertSenceDetaiSuccess"+senceId+1;
       }catch (Exception e){
           result = "inSertSenceDetaiFalse"+senceId+1;
           System.out.println(e);
       }finally {
            sqlSession.close();
           return  result;
       }

    }

}
