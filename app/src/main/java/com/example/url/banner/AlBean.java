package com.example.url.banner;

import java.util.List;

public class AlBean {
        /**
         * id : 80003734
         * name : 尘
         * picUrl : http://p1.music.126.net/JL_id1CFwNJpzgrXwemh4Q==/109951164172892390.jpg
         * tns : []
         * pic_str : 109951164172892390
         * pic : 109951164172892380
         */

        private long id;
        private String name;
        private String picUrl;
        private String pic_str;
        private long pic;
        private List<?> tns;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getPic_str() {
            return pic_str;
        }

        public void setPic_str(String pic_str) {
            this.pic_str = pic_str;
        }

        public long getPic() {
            return pic;
        }

        public void setPic(long pic) {
            this.pic = pic;
        }

        public List<?> getTns() {
            return tns;
        }

        public void setTns(List<?> tns) {
            this.tns = tns;
        }
    }

