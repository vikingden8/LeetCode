#!/usr/bin/python3
#coding=utf-8


def solution():
    content = 'abcefg'
    solutionBasic(content)
    solutionByMap(content)


def solutionByMap(content):
    print('------------------solution by Map------------------------')
    answer = 0
    container = {}
    j = 0 ;
    for i in range(len(content)):
        if content[i] in container:
            j = j if j > container[content[i]] else container[content[i]]
        answer = answer if answer > i - j + 1 else i - j + 1
        container[content[i]] = i + 1
    print('answer : {}'.format(answer))


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
