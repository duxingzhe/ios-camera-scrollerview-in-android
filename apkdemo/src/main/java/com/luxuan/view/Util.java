package com.luxuan.view;

/**
 * Created by Luxuan on 2017/7/24.
 */

public class Util {

    public final static int MIN_INDEX=0;
    public final static int MAX_INDEX=2;
    private static int selected_index=1;

    public static int getCurrentSelectedIndex(){
        return selected_index;
    }

    public static void setSelectedIndex(int index){
        selected_index=index;
    }

}
