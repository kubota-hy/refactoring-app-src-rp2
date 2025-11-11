package jp.co.sss.crud.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import jp.co.sss.crud.util.ConstantMSG;


/**
 * 生年月日入力専用Readerクラス
 * <p>
 * 「yyyy/MM/dd」形式での日付入力を検証します。
 */
public class EmployeeBirthReader implements IConsoleReader {

    

    @Override
    public String getErrorMsg() {
        return "生年月日は「" + ConstantMSG.DATE_PATTERN + "」の形式で入力してください。";
    }

    @Override
    public boolean isValid(String inputString) {
        SimpleDateFormat sdf = new SimpleDateFormat(ConstantMSG.DATE_PATTERN);
        sdf.setLenient(false); // 厳密な日付チェック
        try {
            sdf.parse(inputString);
            return true; // 形式・日付ともに正しい
        } catch (ParseException e) {
            return false; // 不正な形式または存在しない日付
        }
    }

    @Override
    public boolean isParseInt() {
        return false;
    }
}
