
package com.xidian.practice;

import java.util.Random;

/**
 * Created by ZhangChenghui on 2018/3/26.
 * Email: 463170098@qq.com
 */

public  class QpClub {
    public static  final int max = 50;
    public  Desk[] desk = new Desk[max];

    /**
     * 妫嬬墝瀹ゅ垵濮嬪寲
     */
    public void init(){
        for(int i = 1;i<max;i++){
        	desk[i] = new Desk();
            desk[i].setNumber(i);
            desk[i].setState("canOrder");
            desk[i].setLastTime(0);
        }


    }

    /**
     * 妯℃嫙杩愯
     */
    public void run(){
        Random rand = new Random();
        //宸茬粡浣跨敤妫嬬墝妗�
        int randomRun = rand.nextInt(50)+1;
        for(int i=1;i<randomRun+1;i++){

            int j= rand.nextInt(50)+1;

            desk[j].setState("isRun");
            desk[j].setLastTime(rand.nextInt(301));   //鏈�鍓╀綑300鍒嗛挓

        }
        //琚瀹氱殑妫嬬墝妗�
        int randomIsOrder = rand.nextInt(50-randomRun)+1;
        for(int i = 1;i<randomIsOrder+1;i++){
            while(true) {
                int j = rand.nextInt(50) + 1;
                if (desk[j].getState().equals("canOrder")) {
                    desk[j].setState("isOrder");
                    break;
                }
            }
        }
    }

    /**
     *
     * @param number
     * @return
     */
    public Desk chaxun(int number){
        return desk[number];
    }

//    /**
//     *
//     * @param number
//     * @return
//     */
//    public boolean order(int number){
//        if(desk[number].getState().equals("canOrder")){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    /**
//     *
//     * @return
//     */
//    public String tongji(){
//        int orderCount=0,runCount=0,canOrderCount=0,canOrdernumber[] = new int[50];
//        String canOrder = null;
//        for(int i = 1;i<=max;i++){
//            if(desk[i].getState().equals("isRun")){
//                runCount++;
//            }else if(desk[i].getState().equals("isOrder")){
//                orderCount++;
//            }else{
//                canOrderCount++;
//                canOrdernumber[canOrderCount] = i;
//                canOrder = " "+i;
//            }
//        }
//
//        String result = "姝ｅ湪浣跨敤涓殑鏈�+runCount+"妗岋紝琚瀹氱殑鏈�+orderCount+"妗�鍙璁㈢殑鏈�+canOrderCount+"妗岋紝鍒嗗埆涓猴細"+canOrder;
//        return result;
//    }
//
//    /**
//     * 璁¤垂淇℃伅锛�-20涔嬮棿
//     * @return
//     */
//    public String jifei(){
//        Random rand = new Random();
//        int money = rand.nextInt(20);
//        int lastMoney = Integer.parseInt(Preferences.getSettingsParam("lastMoney"))-money;
//        String result = "宸插彂鐢熻垂鐢�+money+"鍏�鐢ㄦ埛浣欓"+lastMoney+"鍏�;
//        return result;
//    }
//
//    /**
//     *
//     * @param money
//     * @return
//     */
//    public String chongzhi(int money){
//        int lastMoney = Integer.parseInt(Preferences.getSettingsParam("lastMoney"))+money;
//        Preferences.setSettingsParam("lastMoney",""+lastMoney);
//        int chongzhi = Integer.parseInt(Preferences.getSettingsParam("chongzhi"))+money;
//        Preferences.setSettingsParam("chongzhi",chongzhi+"");
//        String result = "鐢ㄦ埛鍏呭�"+money+"鍏冿紝鎴愬姛锛岀幇鍦ㄤ綑棰濅负"+lastMoney+"鍏冦�";
//        return result;
//    }

    public static void main(String[] args){
        QpClub qpClub = new QpClub();
        qpClub.init();
    }


}
