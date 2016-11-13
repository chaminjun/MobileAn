package my.sbs.com.myapplication;

import java.util.ArrayList;

/**
 * Created by chaminjun on 2016. 11. 13..
 */

class GenericStorNum<T1, T2>{
    ArrayList<T1> list_String = new ArrayList<T1>();
    ArrayList<T2> list_Num = new ArrayList<T2>();

    void addListString(T1 string1){
        list_String.add(string1);
    }
    void addListNumber(T2 number1){
        list_Num.add(number1);
    }
    String ShowListString(){
        String temp_str = "";
        for(int i = 0; i < list_String.size(); i++)
            temp_str += list_String.get(i);
        return temp_str;
    }
    String ShowListNumber(){
        String temp_str = "";
        for(int i = 0; i < list_Num.size(); i++)
            temp_str += list_Num.get(i) + "\t";
        return temp_str;
    }
    void deleteList(){
        list_Num.clear();
        list_String.clear();
    }
}
