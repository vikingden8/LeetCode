package com.viking.leetcode;

import com.viking.leetcode.base.BaseSolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author : Viking Den<dengwj@gionee.com>
 * Time : 1/27/18 11:14 AM
 */
public class S003_Longest_Substring_Without_Repeating_Characters extends BaseSolution {

    @Override
    protected void solution() {
        String content = "abcabcbb" ;
        solutionBasic(content) ;
        solutionByMap(content) ;
        solutionBySet(content) ;
    }

    private void solutionBasic(String content){
        System.out.println("------------------solution brute force-------------------");
        int n = content.length() ;
        int answer = 0 ;
        for (int i = 0; i < n ; i++ ){
            for (int j = i + 1; j <= n ; j++ ){
                if (!allUnique(content, i, j)){
                    break ;
                }
                answer = Math.max(answer, j - i) ;
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

    private void solutionByMap(String content) {
        System.out.println("------------------solution by Map-------------------");
        int answer = 0 ;
        Map<Character, Integer> container = new HashMap<>() ;
        for (int i = 0 , j = 0 ; i < content.length(); i++){
            if (container.containsKey(content.charAt(i))){
                j = Math.max(j, container.get(content.charAt(i))) ;
            }
            answer = Math.max(answer, i - j + 1) ;
            container.put(content.charAt(i), i + 1) ;
        }
        System.out.println("answer : " + answer);
    }

    private void solutionBySet(String content) {
        System.out.println("------------------solution by Set-------------------");
        int answer = 0 ;
        Set<Character> container = new HashSet<>() ;
        int i = 0, j = 0 ;
        while (i < content.length() && j < content.length()){
            if (container.contains(content.charAt(i))){
                container.remove(content.charAt(j++)) ;
            }else{
                container.add(content.charAt(i++)) ;
                answer = Math.max(answer, i - j) ;
            }
        }
        System.out.println("answer : " + answer);
    }




    public static void main(String[] args) {
        S003_Longest_Substring_Without_Repeating_Characters question = new S003_Longest_Substring_Without_Repeating_Characters();
        question.solution();
    }
}
