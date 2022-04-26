package com.example.custom_listview;

public interface MainCallbacks {

    //public void onMsgFromFragToMain (String sender, String strValue);

    public void onMsgFromFragToMain(String sender, int id, String strValue, String strName, String strMssv, String diemtrungbinh);

    public void onMsgFromFragToMainBtn(String sender, int id, String strValue, String strName, String strMssv, String diemtrungbinh);

    //void onMsgFromFragToMain(String sender, String id, String strValue, String strName, String strMssv, String diemtrungbinh);
}
