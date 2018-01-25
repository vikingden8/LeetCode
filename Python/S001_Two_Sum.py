#!/usr/bin/python3
#coding=utf-8

def solution():
    array = [2, 7, 11, 15, 34, 5, 61, 9]
    result = [-1, -1]
    target = 26
    container = {}
    hasSolution = False
    for index in range(len(array)):
        if target - array[index] in container:
            # bingo , we got it
            hasSolution = True
            result[0] = container[target- array[index]]
            result[1] = index
            break
        else:
            # no match, put it to container
            container[array[index]] = index
    if hasSolution:
        print("Soultion:{} {}".format(result[0], result[1]))
    else:
        print('No Two Sum Solution.')

if __name__ == '__main__':
    solution()
