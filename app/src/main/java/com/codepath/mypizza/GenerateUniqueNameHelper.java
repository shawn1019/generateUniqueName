package com.codepath.mypizza;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Generates unique names for each visible widget in the application
 */

public class GenerateUniqueNameHelper {

    static String TAG = "GenerateUniqueNameHelper";

    public static void generate(View v) {

        //Iterate the sub-views in the v

        if(v instanceof ViewGroup){

            //Note: The widget of 'Listview' is also an instance of ViewGroup, but no ChildCount.
            if(((ViewGroup) v).getChildCount() == 0) {
                Log.i(TAG, "The Unique Widget Name is : " + v.getAccessibilityClassName() + "--" + v.getId());
            }

            for(int i = 0; i < ((ViewGroup) v).getChildCount();i++){
                generate(((ViewGroup) v).getChildAt(i)); //If the sub-view is also an instance of ViewGroup, make recursion
            }

        } else {

            //If the sub-view is not an instance of ViewGroup, print this visible widget name in console.
            if(v.getVisibility() == View.VISIBLE){
                Log.i(TAG,"The Unique Widget Name is : " + v.getAccessibilityClassName() + "--" + v.getId());
            }
        }

    }
}
