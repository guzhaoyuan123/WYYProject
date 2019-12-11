package com.example.url.banner;

import java.util.List;

public class SongBean {
    /**
     * name : 陪你去流浪
     * id : 1374056689
     * pst : 0
     * t : 0
     * ar : [{"id":5781,"name":"薛之谦","tns":[],"alias":[]}]
     * alia : []
     * pop : 100
     * st : 0
     * rt :
     * fee : 0
     * v : 11
     * crbt : null
     * cf :
     * al : {"id":80003734,"name":"尘","picUrl":"http://p1.music.126.net/JL_id1CFwNJpzgrXwemh4Q==/109951164172892390.jpg","tns":[],"pic_str":"109951164172892390","pic":109951164172892380}
     * dt : 274363
     * h : {"br":320000,"fid":0,"size":10976697,"vd":-37398}
     * m : {"br":192000,"fid":0,"size":6586035,"vd":-34777}
     * l : {"br":128000,"fid":0,"size":4390705,"vd":-33044}
     * a : null
     * cd : 01
     * no : 7
     * rtUrl : null
     * ftype : 0
     * rtUrls : []
     * djId : 0
     * copyright : 0
     * s_id : 0
     * mark : 0
     * rtype : 0
     * rurl : null
     * mst : 9
     * cp : 22036
     * mv : 0
     * publishTime : 0
     * privilege : {"id":1374056689,"fee":0,"payed":0,"st":0,"pl":999000,"dl":999000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":999000,"toast":false,"flag":0,"preSell":false}
     */

    private String name;
    private long id;
    private long pst;
    private long t;
    private long pop;
    private long st;
    private String rt;
    private long fee;
    private long v;
    private Object crbt;
    private String cf;
    private AlBean al;
    private long dt;
    private HBean h;
    private MBean m;
    private LBean l;
    private Object a;
    private String cd;
    private long no;
    private Object rtUrl;
    private long ftype;
    private long djId;
    private long copyright;
    private long s_id;
    private long mark;
    private long rtype;
    private Object rurl;
    private long mst;
    private long cp;
    private long mv;
    private long publishTime;
    private PrivilegeBean privilege;
    private List<ArBean> ar;
    private List<?> alia;
    private List<?> rtUrls;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPst() {
        return pst;
    }

    public void setPst(long pst) {
        this.pst = pst;
    }

    public long getT() {
        return t;
    }

    public void setT(long t) {
        this.t = t;
    }

    public long getPop() {
        return pop;
    }

    public void setPop(long pop) {
        this.pop = pop;
    }

    public long getSt() {
        return st;
    }

    public void setSt(long st) {
        this.st = st;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public long getV() {
        return v;
    }

    public void setV(long v) {
        this.v = v;
    }

    public Object getCrbt() {
        return crbt;
    }

    public void setCrbt(Object crbt) {
        this.crbt = crbt;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public AlBean getAl() {
        return al;
    }

    public void setAl(AlBean al) {
        this.al = al;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public HBean getH() {
        return h;
    }

    public void setH(HBean h) {
        this.h = h;
    }

    public MBean getM() {
        return m;
    }

    public void setM(MBean m) {
        this.m = m;
    }

    public LBean getL() {
        return l;
    }

    public void setL(LBean l) {
        this.l = l;
    }

    public Object getA() {
        return a;
    }

    public void setA(Object a) {
        this.a = a;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public Object getRtUrl() {
        return rtUrl;
    }

    public void setRtUrl(Object rtUrl) {
        this.rtUrl = rtUrl;
    }

    public long getFtype() {
        return ftype;
    }

    public void setFtype(long ftype) {
        this.ftype = ftype;
    }

    public long getDjId() {
        return djId;
    }

    public void setDjId(int djId) {
        this.djId = djId;
    }

    public long getCopyright() {
        return copyright;
    }

    public void setCopyright(long copyright) {
        this.copyright = copyright;
    }

    public long getS_id() {
        return s_id;
    }

    public void setS_id(long s_id) {
        this.s_id = s_id;
    }

    public long getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public long getRtype() {
        return rtype;
    }

    public void setRtype(int rtype) {
        this.rtype = rtype;
    }

    public Object getRurl() {
        return rurl;
    }

    public void setRurl(Object rurl) {
        this.rurl = rurl;
    }

    public long getMst() {
        return mst;
    }

    public void setMst(long mst) {
        this.mst = mst;
    }

    public long getCp() {
        return cp;
    }

    public void setCp(long cp) {
        this.cp = cp;
    }

    public long getMv() {
        return mv;
    }

    public void setMv(long mv) {
        this.mv = mv;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public PrivilegeBean getPrivilege() {
        return privilege;
    }

    public void setPrivilege(PrivilegeBean privilege) {
        this.privilege = privilege;
    }

    public List<ArBean> getAr() {
        return ar;
    }

    public void setAr(List<ArBean> ar) {
        this.ar = ar;
    }

    public List<?> getAlia() {
        return alia;
    }

    public void setAlia(List<?> alia) {
        this.alia = alia;
    }

    public List<?> getRtUrls() {
        return rtUrls;
    }

    public void setRtUrls(List<?> rtUrls) {
        this.rtUrls = rtUrls;
    }
}
