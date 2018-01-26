#!/usr/bin/python3
#coding=utf-8


class ListNode:
    def __init__(self, number):
        self.number = number
        self.next = None


def solution():
    # init two list nodes
    nodeFirst = ListNode(3)
    nodeFirst.next = ListNode(4)
    nodeFirst.next.next = ListNode(2)

    nodeSecond = ListNode(4)
    nodeSecond.next = ListNode(6)
    nodeSecond.next.next = ListNode(5)

    dummyHead = ListNode(0)
    curr = dummyHead
    p = nodeFirst
    q = nodeSecond
    carry = 0

    while p or q:
        x = p.number if p else 0
        y = q.number if q else 0
        sum = x + y + carry
        carry, reminder = divmod(sum, 10)
        curr.next = ListNode(reminder)
        curr = curr.next

        p = p.next if p else None
        q = q.next if q else None

    if carry > 0:
        curr.next = ListNode(carry)

    result = dummyHead.next
    while result:
        print('->{}'.format(result.number), end='')
        result = result.next
    print('')


if __name__ == '__main__':
    solution()
