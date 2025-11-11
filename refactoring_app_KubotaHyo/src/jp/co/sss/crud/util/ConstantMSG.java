package jp.co.sss.crud.util;

/*
 * 画面出力の定数をまとめたクラス
 */

public class ConstantMSG {
	
	/** メニュータイトル*/
	public static final String MENU_TITLE = "=== 社員管理システム ===";
	
	/** メニュー項目 */
	public static final String MENU_ALL_DISPLAY = "1.全件表示";
    public static final String MENU_SEARCH_BY_NAME = "2.社員名検索";
    public static final String MENU_SEARCH_BY_DEPT = "3.部署ID検索";
    public static final String MENU_INSERT = "4.新規登録";
    public static final String MENU_UPDATE = "5.更新";
    public static final String MENU_DELETE = "6.削除";
    public static final String MENU_EXIT = "7.終了";
    
    /** メニュー入力促進 */
    public static final String INPUT_MENU_NUMBER = "メニュー番号を入力してください：";
    
    
    /** 共通メッセージ */
    public static final String NO_RECORD_FOUND = "該当者はいませんでした";
    public static final String INSERT_COMPLETE = "社員情報を登録しました";
    public static final String DELETE_COMPLETE = "社員情報を削除しました";
    public static final String UPDATE_COMPLETE = "社員情報を更新しました";
    public static final String INSERT_FAIL="社員登録に失敗しました";
    
    
    /** 項目見出し */
    public static final String EMPLOYEE_HEADER = "社員ID\t社員名\t性別\t生年月日\t部署名";

    /** 入力プロンプト */
    public static final String INPUT_EMP_NAME = "社員名：";
    public static final String INPUT_GENDER = "性別(0:回答しない, 1:男性, 2:女性, 9:その他)：";
    public static final String INPUT_BIRTHDAY = "生年月日(西暦年/月/日)：";
    public static final String INPUT_DEPT_ID = "部署ID(1：営業部、2：経理部、3：総務部)：";
    public static final String INPUT_EMP_ID = "社員IDを入力してください：";
    public static final String INPUT_UPDATE_EMP_ID = "更新する社員の社員IDを入力してください：";
    public static final String INPUT_DELETE_EMP_ID = "削除する社員の社員IDを入力してください：";
    public static final String DATE_PATTERN = "yyyy/MM/dd";
    /** システム終了 */
    public static final String SYSTEM_END = "システムを終了します。";
    
    /** テーブルヘッダーコメント */
    public static final String EMPLOYEE_TABLE_HEADER = "社員ID\t社員名\t性別\t生年月日\t部署名";
    
    // 性別表記
    public static final String GENDER_NONE = "回答なし";
    public static final String GENDER_MALE = "男性";
    public static final String GENDER_FEMALE = "女性";
    public static final String GENDER_OTHER = "その他";
    
    //部署表記
    public static final String DEPT_SALES = "営業部";
    public static final String DEPT_ACCOUNTING = "経理部";
    public static final String DEPT_GENERAL_AFFAIRS = "総務部";
    public static final String DEPT_OTHER = "";
    
    //システムエラー
    public static final String MSG_SYSTEM_ERROR = "システムエラーです";
    
    
    private ConstantMSG() {} // インスタンス化防止

    
	

}
