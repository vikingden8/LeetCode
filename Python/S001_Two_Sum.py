#!/usr/bin/python3
#coding=utf-8

def solution_force(arr, target):
    """
    暴力破解法

    对于给定的target，通过两个循环来遍历数组，故时间复杂度为O（n^2）。

    """
    result = [-1, -1]
    size = len(arr)
    hasSolution = False
    for i, item in enumerate(arr):
        j = i + 1
        while j < size:
            if target == item + arr[j]:
                result = [i, j]
                hasSolution = True
                break
            j += 1
        if hasSolution:
            break
    if hasSolution:
        print("Soultion:{} {}".format(result[0], result[1]))
    else:
        print('No Two Sum Solution.')

def solution(arr, target):
    """
    使用字典的方式，时间复杂度O(n)
    """
    result = [-1, -1]
    container = {}
    hasSolution = False
    for index in range(len(arr)):
        if target - arr[index] in container:
            # bingo , we got it
            hasSolution = True
            result[0] = container[target- arr[index]]
            result[1] = index
            break
        else:
            # no match, put it to container
            container[arr[index]] = index
    if hasSolution:
        print("Soultion:{} {}".format(result[0], result[1]))
    else:
        print('No Two Sum Solution.')

if __name__ == '__main__':
    array = [2, 7, 11, 15, 34, 5, 61, 9]
    target = 26
    solution_force(array, target)
    # solution(array, target)
