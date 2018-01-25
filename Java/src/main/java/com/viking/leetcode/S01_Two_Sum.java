package com.viking.leetcode;

import com.viking.leetcode.base.BaseSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : Viking Den<dengwj@gionee.com>
 * Time : 1/25/18 4:30 PM
 */
public class S01_Two_Sum extends BaseSolution{

    @Override
    protected void solution() {
        int[] array  = {2, 7, 11, 15, 34, 5, 61, 9} ;
        int   target = 26 ;
        Map<Integer, Integer> container = new HashMap<>() ;
        int length = array.length ;
        int[] result = new int[2] ;
        boolean hasSolution = false ;
        for (int index = 0; index < length ; index++){
            if (container.containsKey(target - array[index])){
                //bingo, we got it
                result[0] = container.get(target - array[index]) ;
                result[1] = index ;
                hasSolution = true ;
                break ;
            }else{
                //no match, push it to container
                container.put(array[index], index) ;
            }
        }
        if (hasSolution){
            System.out.println(String.format("Solution : %d %d", result[0], result[1]));
        }else{
            System.out.println("No Solution!");
        }
    }

    public static void main(String[] args) {
        S01_Two_Sum question = new S01_Two_Sum();
        question.solution();
    }
}
