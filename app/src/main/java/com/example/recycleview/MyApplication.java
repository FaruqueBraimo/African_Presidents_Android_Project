package com.example.recycleview;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.President;

public class MyApplication extends Application {


    private  static  List<President> presidentList = new ArrayList<>();
    private static  int nextId = 10;

    public MyApplication() {
        fillPresidentsList();
    }

    private void fillPresidentsList() {

        President president1 = new President(1, "João Manuel Gonçalves Lourenço", "Angola" ,"2018" ,"https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/2018-07-04_President_Jo%C3%A3o_Louren%C3%A7o-0555.jpg/200px-2018-07-04_President_Jo%C3%A3o_Louren%C3%A7o-0555.jpg" );
        President president2 = new President(2, "Filipe Jacinto Nyusi ",  "Mozambique", "2015"  ,"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Filipe_Nyusi_-_2019_%28cropped%29.jpg/220px-Filipe_Nyusi_-_2019_%28cropped%29.jpg" );
        President president3 = new President(3, "Hage Geingob", "Namibia","2015" ,"https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/H.E._Hage_Gottfried_Geingob_%28cropped%29.jpg/220px-H.E._Hage_Gottfried_Geingob_%28cropped%29.jpg" );
//        President president4 = new President(4, "João Manuel Gonçalves Lourenço", "2017" ,"https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/2018-07-04_President_Jo%C3%A3o_Louren%C3%A7o-0555.jpg/200px-2018-07-04_President_Jo%C3%A3o_Louren%C3%A7o-0555.jpg" );
//        President president5 = new President(5, "João Manuel Gonçalves Lourenço", "2017" ,"https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/2018-07-04_President_Jo%C3%A3o_Louren%C3%A7o-0555.jpg/200px-2018-07-04_President_Jo%C3%A3o_Louren%C3%A7o-0555.jpg" );
//        President president6 = new President(6, "João Manuel Gonçalves Lourenço", "2017" ,"https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/2018-07-04_President_Jo%C3%A3o_Louren%C3%A7o-0555.jpg/200px-2018-07-04_President_Jo%C3%A3o_Louren%C3%A7o-0555.jpg" );

        presidentList.addAll(Arrays.asList(new President[]{president1,  president2, president3}));

    }


    public static List<President> getPresidentList() {
        return presidentList;
    }

    public static void setPresidentList(List<President> presidentList) {
        MyApplication.presidentList = presidentList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
