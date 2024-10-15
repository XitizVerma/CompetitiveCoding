package Projects.RateLimiting;

import java.time.ZonedDateTime;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;


public class TokenBucket {

    public static final Integer TIME_FACTOR = 20;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter Bucket Capacity");
        Long bucketCapacity = scr.nextLong();
        Map.Entry<Long,Long> currCapacity = new AbstractMap.SimpleEntry<>(bucketCapacity,ZonedDateTime.now().toEpochSecond());
        while(true){
            System.out.println("Enter the request");
            int req = scr.nextInt();
            currCapacity = refreshCurrentTokens(currCapacity,bucketCapacity);
            if(currCapacity.getKey()>0){
                // PROCESS REQUEST req
                currCapacity = new AbstractMap.SimpleEntry<>(currCapacity.getKey()-1,currCapacity.getValue());
            }else{
                //throw Exception("Threshold number of requests exceeded");
            }
        }
    }

    public static Map.Entry<Long,Long> refreshCurrentTokens(Map.Entry<Long,Long> currCapacity,Long bucketCapacity){
        Long diffTime = ZonedDateTime.now().toEpochSecond() - currCapacity.getValue();
        Long intervals = diffTime/TIME_FACTOR;
        currCapacity.getValue();
        if(currCapacity.getKey() + intervals>=bucketCapacity){
            return currCapacity = new AbstractMap.SimpleEntry<>(bucketCapacity,ZonedDateTime.now().toEpochSecond());
        }else {
            Long newEpoch = currCapacity.getValue() + intervals*TIME_FACTOR;
            return currCapacity = new AbstractMap.SimpleEntry<>((currCapacity.getKey() + intervals), newEpoch);
        }
    }


}


