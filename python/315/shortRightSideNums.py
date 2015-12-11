#! /usr/bin/env python2
import sys

def solution(nums):
    result = []
    sortedList = []
    for num in nums[::-1]:
        if len(sortedList)==0:
            sortedList=[num]
            result = [0]
        elif num < sortedList[0]:
            result = [0]+ result
            sortedList = [num] + sortedList
        elif num > sortedList[-1]:
            result = [len(sortedList)] + result
            sortedList = sortedList + [num]
        else:
            i,j=0,len(sortedList)-1
            while i+1 < j:
                mid = i + (j-i)/2
                if num < sortedList[mid]:
                    j = mid
                else:
                    i = mid
            result = [j] + result
            sortedList = sortedList[0:j] + [num] + sortedList[j:]
        print sortedList
        print result
    return result

if __name__=="__main__":
    nums = [int(s) for s in sys.stdin.readline().split()]
    print (solution(nums))
