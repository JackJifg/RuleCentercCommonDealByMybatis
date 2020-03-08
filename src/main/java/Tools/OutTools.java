package Tools;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @className: OutTools
 * @description: 输出到文本
 * @author: ouyangcl
 * @create: 2019-06-11 17:34
 **/
public class OutTools {

    public static void outPut(String db) throws Exception {
        File file = new File("C:\\Users\\Administrator\\Desktop\\Ruleconfig\\DB.txt");//导出文件位置
        FileOutputStream outputStream = new FileOutputStream(file, true);
        String str = db;
        byte[] b = str.getBytes();
        outputStream.write(b);
        outputStream.close();
    }


}
