#!/usr/bin/env python2
# coding: utf-8

import sys

def find_max_value(nums):
    nums=[i for i in nums if i!= 0]
    nums.insert(0,1)
    nums.append(1)
    lookup=[[0] * len(nums) for i in range(len(nums))]
    #print lookup
    return find(nums, 0, len(nums)-1, lookup)

def find(nums,start,end,lookup):
    if start+1==end:
        return 0
    if lookup[start][end]!=0:
        return lookup[start][end]
    maxValue = 0
    for i in range(start+1,end):
        #pass
        maxValue = max(maxValue, nums[start]*nums[i]*nums[end] + find(nums, start, i, lookup) + \
                find(nums, i, end, lookup))
    lookup[start][end]=maxValue
    return maxValue

if __name__ == '__main__':
    for i in range(int(sys.stdin.readline())):
        nums = [int(s) for s in sys.stdin.readline().split()]
        print nums
        print find_max_value(nums)
