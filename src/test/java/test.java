import Tools.CommonUtils;
import Tools.OutTools;
import Tools.RuleExtTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: test
 * @description: 导出bd
 * @author: ouyangcl
 * @create: 2019-06-11 11:53
 **/
public class test {

    public static void main(String[] args) throws Exception {
        //插入数据库场景，场景明细表，场景关联表，并导出该场景到桌面文件
        /*1.第一次使用需修改OutTools中导出文件路径，
         *2.将senceMapper.xml文件中getPreSence里面senceId范围改成自己的区间
         *3.修改要素值时，对应放开sence.java文件中Sence构造器中初始化和提交时的senceCode，senceName赋值
         *4.第一次使用时，需手动在数据库自己的sence，sence_detail,sence_rule_rel的区间插入一条数据，此方法需要读取上一条数据进行插入
         *5.如场景下需要关联新增规则，需先手动将新增规则插入数据库之后再使用此方法
         */
/*        String senceName = "星级机位租用注销";
        //要素值
        Map value = new HashMap();
        value.put(100000001L, "192025900004");
        value.put(100000002L, "INIT");
//        value.put(100000002L, "COMMIT");
        //关联规则id
        String ruleIds = "100040054";//规则以英文逗号隔开 100040054,100040053
        String newSenceId =  CommonUtils.addSence(senceName, value, ruleIds);
        CommonUtils.getAllSenceDbString(newSenceId);*/

//        规则场景DB全量导出 根据senceIds
        String senceID = "210000008,210000009,210000011,100003021,100003023";
        CommonUtils.getAllSenceDbString(senceID);

//        规则db导出 根据ruleIds
//          String ruleIds = "100000923,100001054";
//          CommonUtils.getRuleDbString(ruleIds);

//        规则提示语导出 根据exceCodes
//        String exceCodes = "RULE_DESC_910,RULE_DESC_920,RULE_DESC_923,RULE_DESC_921,RULE_DESC_911,RULE_DESC_912,RULE_DESC_914,RULE_DESC_915,RULE_DESC_913,RULE_DESC_916,RULE_DESC_917,RULE_DESC_918,RULE_DESC_919,RULE_DESC_10056";
//        CommonUtils.getAllExceCodeDbString(exceCodes);

//        警告规则导出 根据extIds
//        String extIds = "100200032,100000058";
//        CommonUtils.getRuleExtDbString(extIds);

//        场景加警告db 根据senceIds Val值
//        CommonUtils.getAllSenceAndRuleExtDbString("100001341", "W");
    }
}
