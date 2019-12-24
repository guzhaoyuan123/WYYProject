package com.example.url.resoubang;

import java.util.List;

public class SerachReSouBang {


    /**
     * code : 200
     * data : [{"searchWord":"下山","score":1984472,"content":"一身正气荡人间 除暴安良我心愿","source":0,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"alg_statistics"},{"searchWord":"隔壁老樊","score":1628938,"content":"老樊在平庸的世界拥抱你","source":0,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"alg_statistics"},{"searchWord":"好想爱这个世界啊","score":1583879,"content":"用温暖力量的歌声 感知这个世界","source":1,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"featured"},{"searchWord":"勇气","score":1449993,"content":"希望这首歌能在冬夜里温暖你","source":0,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"alg_statistics"},{"searchWord":"静止","score":1319319,"content":"大老师的十五岁 你听懂了吗？","source":0,"iconType":2,"iconUrl":"https://p1.music.126.net/szWeddITZIVxpvQ0QywzcQ==/109951163967989323.png","url":"","alg":"alg_statistics"},{"searchWord":"半糖主义","score":1317639,"content":"这首歌很值得各位当做爱情宝典了","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"杀死那个石家庄人","score":1145535,"content":"生于理想，死于欲望","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"野狼disco","score":1045721,"content":"来 左边 跟我一起画个龙","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"李荣浩老友记","score":1044733,"content":"旧朋友，就不陪你这么久啦","source":1,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"featured"},{"searchWord":"杨千嬅","score":960745,"content":"听粤语歌的人一定不能错过她！","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"够爱","score":914496,"content":"偶像剧《终极一家》主题曲！","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"我和我的祖国","score":892530,"content":"王菲动人演绎，歌唱生活美好","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"薛之谦","score":877626,"content":"老薛是那一片最认真的雪","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"颜人中","score":873000,"content":"有着独特声线的魅力男嗓！","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"世间美好与你环环相扣","score":848346,"content":"愿世间的美好，与你环环相扣","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"莫文蔚","score":765391,"content":"慢慢喜欢属于莫文蔚的阴天","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"国王与乞丐","score":760107,"content":"唱作鬼才华晨宇的经典创作曲目","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"你的答案","score":725009,"content":"打破一切恐惧 我能找到答案","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"我相信","score":674545,"content":"企业年会必备洗脑旋律","source":0,"iconType":5,"iconUrl":"https://p1.music.126.net/PtgUJbcvDAY0HKWpmOB2HA==/109951163967988470.png","url":"","alg":"alg_statistics"},{"searchWord":"明天会更好","score":672196,"content":"大型晚会必备合唱歌曲","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"}]
     * message : success
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }
}
