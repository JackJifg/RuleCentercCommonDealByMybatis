package Tools;

import entity.BsExceDefine;
import entity.Rule;
import mapper.BsExceDefineMapper;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @className: BsExceDefineTools
 * @description: 规则提示语工具类
 * @author: ouyangcl
 * @create: 2019-06-12 13:00
 **/
public class BsExceDefineTools {

    static SqlSession session = DBTools.getSession();
    static BsExceDefineMapper bsExceDefineMapper = session.getMapper(BsExceDefineMapper.class);


    public static List<BsExceDefine> getAll(List<String> exceCodes) {
        List<BsExceDefine> bsExceDefineList = bsExceDefineMapper.getAll(exceCodes);
        return bsExceDefineList;
    }

    public static String dbString(List<String> exceCodes) {
        List<BsExceDefine> bsExceDefineList = bsExceDefineMapper.getAll(exceCodes);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("--------------规则提示语------").append(bsExceDefineList.size()).append("---条\n");
        for (int i = 0; bsExceDefineList.size() > 0 && i < bsExceDefineList.size(); i++) {
            String deleString = "delete from base.BS_EXCE_define where exce_code='"+bsExceDefineList.get(i).getExceCode()+"';";
            String insertString = "insert into base.bs_exce_define (EXCE_CODE, MODULE_ID, EXCE_CLASS_CODE, EXCE_NAME, EXCE_REASON, SCHEME_ID, STATE, DONE_CODE, DONE_DATE, OP_ID, ORG_ID, REMARKS)\n" +
                    "values ('"+bsExceDefineList.get(i).getExceCode()+"', "+bsExceDefineList.get(i).getModuleId()+", '"+bsExceDefineList.get(i).getExceClassCode()+"', '"+bsExceDefineList.get(i).getExceName()+"', '"+bsExceDefineList.get(i).getExceReason()+"', '"+bsExceDefineList.get(i).getSchemeId()+"', '"+bsExceDefineList.get(i).getState()+"', '"+bsExceDefineList.get(i).getDoneCode()+"', to_date('"+formatDate(bsExceDefineList.get(i).getDoneDate())+"', 'dd-mm-yyyy hh24:mi:ss'), '"+bsExceDefineList.get(i).getOpId()+"', '"+bsExceDefineList.get(i).getOrgId()+"', '"+bsExceDefineList.get(i).getRemarks()+"');";
            stringBuffer.append(deleString).append("\n").append(insertString).append("\n").append("\n");
        }
        return stringBuffer.toString().replaceAll("'null'",""+null+"");
    }

    public static String formatDate(Date date) {
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sf.format(date);
    }
}
