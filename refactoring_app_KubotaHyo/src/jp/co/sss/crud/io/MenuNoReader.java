package jp.co.sss.crud.io;

/**
 * メニュー番号入力専用Readerクラス
 * <p>
 * 1〜7 の範囲の整数値を受け付ける。
 */
public class MenuNoReader implements IConsoleReader {

    @Override
    public String getErrorMsg() {
        return "1〜7の範囲でメニュー番号を入力してください。";
    }

    @Override
    public boolean isValid(String inputString) {
        try {
            int menuNo = Integer.parseInt(inputString);
            return menuNo >= 1 && menuNo <= 7;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isParseInt() {
        return true;
    }
}
