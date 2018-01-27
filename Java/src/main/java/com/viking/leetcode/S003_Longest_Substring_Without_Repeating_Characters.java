package com.viking.leetcode;

import com.viking.leetcode.base.BaseSolution;

import java.util.HashSet;
import java.util.Set;

/**
 * Author : Viking Den<dengwj@gionee.com>
 * Time : 1/27/18 11:14 AM
 */
public class S003_Longest_Substring_Without_Repeating_Characters extends BaseSolution {



    @Override
    protected void solution() {
        String content = "abcabcbbb" ;
        solutionBasic(content) ;
    }

    private void solutionBasic(String content){
        System.out.println("------------------solution 1-------------------");
        int n = content.length() ;
        int answer = 0 ;
        for (int i = 0; i < n ; i++ ){
            for (int j = i + 1; j <= n ; j++ ){
                if (allUnique(content, i, j)){
                    answer = Math.max(answer, j - i) ;
                }
            }
        }
        System.out.println("answer : " + answer);
    }

    private boolean allUnique(String s, int start, int end){
        Set<Character> container = new HashSet<>() ;
        for (int i = start ; i < end ; i++ ){
            Character ch = s.charAt(i) ;
            if (container.contains(ch)) return false ;
            container.add(ch) ;
        }
        return true ;
    }


    public static void main(String[] args) {
        S003_Longest_Substring_Without_Repeating_Characters question = new S003_Longest_Substring_Without_Repeating_Characters();
        question.solution();
    }
}
