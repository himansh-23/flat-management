package com.flat.management.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static List<String> createUserIds(){

        List<String> userIds = new ArrayList<>(6);
        for(int i =0;i<6;i++){
            userIds.add(RandomStringUtils.randomAlphanumeric(6).toUpperCase());
        }
        return userIds;
    }
}
