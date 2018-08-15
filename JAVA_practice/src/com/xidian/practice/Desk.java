package com.xidian.practice;

/**
 * Created by ZhangChenghui on 2018/3/26.
 * Email: 463170098@qq.com
 */

public class Desk {
    private int number;  //妫嬬墝妗屽彿
    private String state;  //浣跨敤鐘舵�  isRun姝ｅ湪琚娇鐢ㄣ�isOrder琚瀹氥�canOrder鍙互棰勫畾
    private int lastTime;
    
//    public Desk(){
//    	number = 0;
//    	state = null;
//    	lastTime = 0;
//    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public int getLastTime() {
        return lastTime;
    }

    public void setLastTime(int lastTime) {
        this.lastTime = lastTime;
    }
}
