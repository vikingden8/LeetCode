#!/usr/bin/python3
#coding=utf-8


def solution():
    content = 'abcefggesf'
    solutionBasic(content)
    #solutionByMap(content)


def solutionBasic(content):
    print('------------------solution brute force------------------------')
    answer = 0
    for i in range(len(content)):
        for j in range(i+1, len(content) + 1):
            if not allUnique(content, i, j):
                break
            curr = j - i
            answer = answer if curr < answer else curr
    print('answer : {}'.format(answer))


def allUnique(content, i, j):
    container = []
    for i in range(i, j):
        if content[i] not in container:
            container.append(content[i])
        else:
            return False
    return True


if __name__ == '__main__':
    solution()
