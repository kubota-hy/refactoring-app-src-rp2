package jp.co.sss.crud.main;

import static jp.co.sss.crud.util.ConstantMSG.*;
import static jp.co.sss.crud.util.ConstantValue.*;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.IConsoleReader;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.IEmployeeService;

/**
 * 社員情報管理システムのメインクラス。
 * <p>
 * メニュー表示・ユーザー入力・サービス呼び出しを制御する。
 */
public class MainSystem {

    public static void main(String[] args) {
        // 出力・入力の管理
        ConsoleWriter writer = new ConsoleWriter();
        IConsoleReader menuReader = new MenuNoReader();

        while (true) {
            try {
                // ===== メニュー表示 =====
                writer.printMenu();
                System.out.print(INPUT_MENU_NUMBER);

                // ===== メニュー番号入力 =====
                int menuNo = (Integer) menuReader.input();

                // ===== 終了選択 =====
                if (menuNo == MENU_EXIT_NUM) {
                    writer.printLine(SYSTEM_END);
                    break;
                }

                // ===== サービスインスタンス生成 =====
                IEmployeeService service = IEmployeeService.getInstanceByMenuNo(menuNo);

                if (service == null) {
                    writer.printLine("該当するメニューが存在しません。");
                    continue;
                }

                // ===== ビジネスロジック実行 =====
                service.execute();

            } catch (IllegalInputException e) {
                // 入力ミス時
                writer.printLine("入力エラー：" + e.getMessage());
            } catch (SystemErrorException e) {
                // システム例外時
                writer.printLine("システムエラーが発生しました：" + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                // 想定外の例外
                writer.printLine("予期せぬエラーが発生しました：" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
