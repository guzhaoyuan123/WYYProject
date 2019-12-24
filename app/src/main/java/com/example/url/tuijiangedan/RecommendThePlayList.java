package com.example.url.tuijiangedan;

import java.util.List;
//歌单中歌单广场的推荐歌单的请求类结果
public class RecommendThePlayList {
    /**
     * hasTaste : false
     * code : 200
     * category : 0
     * result : [{"id":3112654749,"type":0,"name":"岁月万花筒 | 歌声中重温即将逝去的10年代","copywriter":"编辑推荐：过去的10年代，哪首歌是你的最爱呢~","picUrl":"https://p2.music.126.net/V9D5mC-EgLxzV-k-jugmyA==/109951164541181281.jpg","canDislike":false,"trackNumberUpdateTime":1575987842624,"playCount":1133532,"trackCount":55,"highQuality":false,"alg":"featured"},{"id":3112668702,"type":0,"name":"致 那些未曾说出口的爱 | 硬地新歌vol.6","copywriter":"编辑推荐：献给那些我们未曾说出口的爱~","picUrl":"https://p2.music.126.net/Sj9pAF0-rrlA4rtuVvvYDw==/109951164541162460.jpg","canDislike":false,"trackNumberUpdateTime":1575981314329,"playCount":814865,"trackCount":35,"highQuality":false,"alg":"featured"},{"id":979321026,"type":0,"name":"好听到单曲循环","copywriter":"热门推荐","picUrl":"https://p2.music.126.net/1gNcBmzdIaQtU00Dvp_TvQ==/109951163912081772.jpg","canDislike":true,"trackNumberUpdateTime":1576044214783,"playCount":104009600,"trackCount":165,"highQuality":false,"alg":"cityLevel_A"},{"id":3068492515,"type":0,"name":"2019就快结束了，你的愿望实现了没","copywriter":"热门推荐","picUrl":"https://p2.music.126.net/P347rpSGpaP4DoKbZ6Gyiw==/109951164499552611.jpg","canDislike":true,"trackNumberUpdateTime":1574599063420,"playCount":2244801,"trackCount":46,"highQuality":false,"alg":"cityLevel_A"},{"id":3027102694,"type":0,"name":"欧美励志//只有奋笔疾书，才能逆风前行","copywriter":"热门推荐","picUrl":"https://p2.music.126.net/1Nx7mLel4YoVjEYpPhqBYw==/109951164503487070.jpg","canDislike":true,"trackNumberUpdateTime":1575634239552,"playCount":904103,"trackCount":41,"highQuality":false,"alg":"cityLevel_A"},{"id":1984054025,"type":0,"name":"赖冠霖的手机歌单","copywriter":"热门推荐","picUrl":"https://p2.music.126.net/wiJhSfiYEqfR2BPZvHrY8w==/19060034067946412.jpg","canDislike":true,"trackNumberUpdateTime":1568090396860,"playCount":862015,"trackCount":71,"highQuality":false,"alg":"cityLevel_A"}]
     */

    private boolean hasTaste;
    private int code;
    private int category;
    private List<ResultBean> result;

    public boolean isHasTaste() {
        return hasTaste;
    }

    public void setHasTaste(boolean hasTaste) {
        this.hasTaste = hasTaste;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }
}
