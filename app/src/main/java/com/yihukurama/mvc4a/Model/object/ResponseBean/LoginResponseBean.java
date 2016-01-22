package com.yihukurama.mvc4a.model.object.responsebean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dengshuai on 16/1/7.
 * 服务器返回的response都可以转化为实体类，方便程序APP处理业务逻辑
 * 所有成员赋初值，保证服务器未传值时不为null
 */
public class LoginResponseBean extends BaseResponseBean {

    /**
     * 默认的构造方法必须不能省，不然不能解析
     */
    public LoginResponseBean() {
        super();
    }

    public LoginResponseBean(List<LoginData> loginDatas) {
        super();
        this.outdata = loginDatas;
    }

    private List<LoginData> outdata;

    public List<LoginData> getOutdata() {
        return outdata;
    }

    public void setOutdata(List<LoginData> outdata) {
        this.outdata = outdata;
    }

    public class LoginData implements Serializable {
        private String ACCESSTOKEN="";
        private String RESULTDESC="";
        private String USER_ICON_URL="";
        private String UIDTYPE="";
        private String RESULT="";
        private String DATAUPLOADFLAG="";
        private String USERID="";
        private String AICHAID="";
        private String HX_USERNAME="";
        private String HX_PASSWD="";
        private String STATE="";
        private String ICheckUser;


        public String getHX_USERNAME() {
            return HX_USERNAME;
        }

        public void setHX_USERNAME(String hX_USERNAME) {
            HX_USERNAME = hX_USERNAME;
        }

        public String getHX_PASSWD() {
            return HX_PASSWD;
        }

        public void setHX_PASSWD(String hX_PASSWD) {
            HX_PASSWD = hX_PASSWD;
        }

        public String getUIDTYPE() {
            return UIDTYPE;
        }

        public void setUIDTYPE(String uIDTYPE) {
            UIDTYPE = uIDTYPE;
        }

        public String getICheckUser() {
            return ICheckUser;
        }

        public void setICheckUser(String iCheckUser) {
            ICheckUser = iCheckUser;
        }

        public String getRESULTDESC() {
            return RESULTDESC;
        }

        public void setRESULTDESC(String rESULTDESC) {
            RESULTDESC = rESULTDESC;
        }

        public String getUSER_ICON_URL() {
            return USER_ICON_URL;
        }

        public void setUSER_ICON_URL(String uSER_ICON_URL) {
            USER_ICON_URL = uSER_ICON_URL;
        }

        public String getACCESSTOKEN() {
            return ACCESSTOKEN;
        }

        public void setACCESSTOKEN(String aCCESSTOKEN) {
            ACCESSTOKEN = aCCESSTOKEN;
        }

        public String getRESULT() {
            return RESULT;
        }

        public void setRESULT(String rESULT) {
            RESULT = rESULT;
        }

        public String getDATAUPLOADFLAG() {
            return DATAUPLOADFLAG;
        }

        public void setDATAUPLOADFLAG(String dATAUPLOADFLAG) {
            DATAUPLOADFLAG = dATAUPLOADFLAG;
        }

        public String getUSERID() {
            return USERID;
        }

        public void setUSERID(String uSERID) {
            USERID = uSERID;
        }

        public String getAICHAID() {
            return AICHAID;
        }

        public void setAICHAID(String aICHAID) {
            AICHAID = aICHAID;
        }

        public String getSTATE() {
            return STATE;
        }

        public void setSTATE(String sTATE) {
            STATE = sTATE;
        }

    }
}
