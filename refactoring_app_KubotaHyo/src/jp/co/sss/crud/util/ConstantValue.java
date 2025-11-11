package jp.co.sss.crud.util;

public class ConstantValue {
	 // 性別
    public static final int GENDER_NONE = 0;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_OTHER = 9;

    // 部署ID
    public static final int DEPT_SALES = 1;
    public static final int DEPT_ACCOUNTING = 2;
    public static final int DEPT_GENERAL_AFFAIRS = 3;
    
    //Menu番号
    public static final int MENU_SELECT_ALL = 1;
    public static final int MENU_SEARCH_EMP_NAME = 2;
    public static final int MENU_SEARCH_DEPT_ID = 3;
    public static final int MENU_INSERT = 4;
    public static final int MENU_UPDATE = 5;
    public static final int MENU_DELETE = 6;
    public static final int MENU_EXIT_NUM = 7;

    private ConstantValue() {} // インスタンス化防止

}
