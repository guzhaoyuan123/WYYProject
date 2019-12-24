package com.example.url.yuncunjingxuanshiping;

//云村的请求类结果
public class YunCunJingXuanSHiPing {

    /**
     * loadingPic :
     * bufferPic :
     * loadingPicFS :
     * bufferPicFS :
     * subed : false
     * data : {"id":10904989,"name":"麻雀","artistId":4292,"artistName":"李荣浩","briefDesc":"","desc":"我们和生活在城市中的麻雀一样\n虽然渺小 但是五脏俱全\n感情 思想 理想\n令我们成为 人群中的一只只麻雀\n《麻雀》MV由李荣浩自编自导自演，拍摄耗时9分钟，拍了3遍，后期制作2个月之久。通过一镜到底的拍摄手法将我们的视线和情绪聚焦到某个点上，或许你会觉得镜中人物像你，亦或镜中之人就是你，像只麻雀，没有终点，为了梦想拼命在飞，证明着自己的存在。","cover":"http://p1.music.126.net/-LkI0yoGquAWFl2W3kEXIg==/109951164536308330.jpg","coverId":109951164536308340,"playCount":602192,"subCount":3576,"shareCount":2093,"likeCount":14623,"commentCount":2301,"duration":267000,"nType":0,"publishTime":"2019-12-09","brs":{"240":"http://vodkgeyttp8.vod.126.net/cloudmusic/obj/core/632873387/6932ce4f583c09e086554ebc2b54a664.mp4?wsSecret=d39ccc6d7b9f0c1486399b0f29c1ec1b&wsTime=1576151286","480":"http://vodkgeyttp8.vod.126.net/cloudmusic/obj/core/632873387/5cffcf4f2e36259c20bdd36ff256a697.mp4?wsSecret=e3377feb501336aace71980c4f6517f3&wsTime=1576151286","720":"http://vodkgeyttp8.vod.126.net/cloudmusic/obj/core/632873387/14845ceb9062d95272bd27abdf78312e.mp4?wsSecret=8838cce196d8f33006f65b13c4841b3b&wsTime=1576151286","1080":"http://vodkgeyttp8.vod.126.net/cloudmusic/obj/core/632873387/4db28fdf08f3f1e6aee1c3a19575316e.mp4?wsSecret=8571b8f1f949e45a576e69fc3e6ae127&wsTime=1576151286"},"artists":[{"id":4292,"name":"李荣浩"}],"isReward":false,"commentThreadId":"R_MV_5_10904989"}
     * code : 200
     */

    private String loadingPic;
    private String bufferPic;
    private String loadingPicFS;
    private String bufferPicFS;
    private boolean subed;
    private DataBean data;
    private int code;

    public String getLoadingPic() {
        return loadingPic;
    }

    public void setLoadingPic(String loadingPic) {
        this.loadingPic = loadingPic;
    }

    public String getBufferPic() {
        return bufferPic;
    }

    public void setBufferPic(String bufferPic) {
        this.bufferPic = bufferPic;
    }

    public String getLoadingPicFS() {
        return loadingPicFS;
    }

    public void setLoadingPicFS(String loadingPicFS) {
        this.loadingPicFS = loadingPicFS;
    }

    public String getBufferPicFS() {
        return bufferPicFS;
    }

    public void setBufferPicFS(String bufferPicFS) {
        this.bufferPicFS = bufferPicFS;
    }

    public boolean isSubed() {
        return subed;
    }

    public void setSubed(boolean subed) {
        this.subed = subed;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
