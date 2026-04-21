package com.intr.utils;

public enum AprvView {
    LEAV("Leav", "intr_aprv_detl_1010.jsp", "LEAV", "leavList"),
    EXP("Exp", "intr_aprv_detl_1011.jsp", "PAY", "prepayList"),
    ITEM("Item", "intr_aprv_detl_1012.jsp", "REQ", "reqList"),
    CORP("Corp", "intr_aprv_detl_1013.jsp", "CORP", "corpList");

    private final String code;  
    private final String viewNm;    
    private final String temptypeCd; 
    private final String modelNm;   

    AprvView(String typeCode, String viewNm, String temptypeCd, String modelNm) {
        this.code = typeCode;
        this.viewNm = viewNm;
        this.temptypeCd = temptypeCd;
        this.modelNm = modelNm;
    }

    public static AprvView findCode(String code) {
        if (code == null) return null;
        for (AprvView type : AprvView.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }

    public String getCode() { return code; }
    public String getViewNm() { return viewNm; }
    public String getTemptypeCd() { return temptypeCd; }
    public String getModelNm() { return modelNm; }
}
