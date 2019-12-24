package com.example.url.sousuoliebiao;

public class SearchList {

    /**
     * result : {"allMatch":[{"keyword":"海阔天空","type":1,"alg":"alg_psug_a","lastKeyword":"海阔天空"},{"keyword":"海阔天空抖音版","type":1,"alg":"alg_psug_a","lastKeyword":"海阔天空"},{"keyword":"海阔天空国语版","type":1,"alg":"alg_psug_a","lastKeyword":"海阔天空"},{"keyword":"海阔天空伴奏","type":1,"alg":"alg_psug_a","lastKeyword":"海阔天空"},{"keyword":"海阔天空dj","type":1,"alg":"alg_psug_a","lastKeyword":"海阔天空"},{"keyword":"海阔天空国语","type":1,"alg":"alg_psug_a","lastKeyword":"海阔天空"}]}
     * code : 200
     */

    private ResultBean result;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
