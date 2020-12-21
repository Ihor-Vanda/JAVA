package Lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StringFormatter<T extends Savable> {
    public String getString(List<T> objects){
        StringBuilder temp = new StringBuilder();
        for(T t : objects){
            temp.append(getStr(t.getInfo()));
        }
        return temp.toString();
    }

    private String getStr(HashMap<Integer,String> map){
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < map.size(); i++) {
            temp.append(map.get(i)).append(";");
        }
        return temp + System.lineSeparator();
    }

    public static List<List<String>> createList(String str){
        List<List<String>> newList = new ArrayList<>();
        for(String s : str.split(System.lineSeparator())){
            newList.add(Arrays.asList(s.split(";")));
        }
        return newList;
    }
}

