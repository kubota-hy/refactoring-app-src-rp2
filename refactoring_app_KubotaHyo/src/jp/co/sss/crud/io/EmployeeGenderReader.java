package jp.co.sss.crud.io;

/**
 * 性別入力専用Readerクラス
 * <p>
 * 0, 1, 2, 9 のいずれかを受け付ける。
 * 0: 回答しない, 1: 男性, 2: 女性, 9: その他
 */
public class EmployeeGenderReader implements IConsoleReader {

    @Override
    public String getErrorMsg() {
        return "性別は 0(回答しない)、1(男性)、2(女性)、9(その他) のいずれかを入力してください。";
    }

    @Override
    public boolean isValid(String inputString) {
        try {
            int gender = Integer.parseInt(inputString);
            return gender == 0 || gender == 1 || gender == 2 || gender == 9;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isParseInt() {
        return true;
    }
}
