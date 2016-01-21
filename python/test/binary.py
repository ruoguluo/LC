#! /usr/bin/env python2
nums = [10,20,30,40,50]
x = 25
i,j = 0, len(nums)-1
while i+1<j:
    mid = i+(j-i)/2
    if x < nums[mid]:
        j = mid
    else:
        i = mid
nums = nums[0:j] + [x] + nums[j:]

print nums
