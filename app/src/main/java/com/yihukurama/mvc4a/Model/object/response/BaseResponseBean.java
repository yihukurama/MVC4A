package com.yihukurama.mvc4a.model.object.response;

import java.io.Serializable;

/**
 * Created by dengshuai on 15/12/31.
 * 业务实体的基类，所有业务实体类需要序列化到磁盘的都必须继承该类
 * 基类根据具体业务接口文档的共性而设计
 *
 * 这里所有成员都是我服务器响应时一定会返回给我的内容
 * 注意
 * 所有成员赋初值，保证服务器未传值时不为null
 */
public class BaseResponseBean implements Serializable{


    private String outresult = "";
    private String outdesc = "";
    private int pageno = 0;
    private int pagesize = 0;
    private String maxpage = "";


    public BaseResponseBean() {

    }

    public BaseResponseBean(String outresult, String outdesc, int pageno, int pagesize, String maxpage) {
        this.outresult = outresult;
        this.outdesc = outdesc;
        this.pageno = pageno;
        this.pagesize = pagesize;
        this.maxpage = maxpage;
    }

    public String getOutresult() {
        return outresult;
    }

    public void setOutresult(String outresult) {
        this.outresult = outresult;
    }

    public String getOutdesc() {
        return outdesc;
    }

    public void setOutdesc(String outdesc) {
        this.outdesc = outdesc;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public String getMaxpage() {
        return maxpage;
    }

    public void setMaxpage(String maxpage) {
        this.maxpage = maxpage;
    }
}
