#!/usr/bin/env python2
# coding: utf-8

import sys

class Solution(object):
    def minArea(image, x, y):
        """
        :type image: List[List[str]]
        :type x: int
        :type y: int
        :rtype: int
        """
        global sum
        m,n = len(image), len(image[0])
        sum = [[0]*(n+1) for i in range(m+1)]
        for i in range(1,m+1):
            for j in range(1,n+1):
                sum[i][j]=sum[i][j-1]+sum[i-1][j]+image[i-1][j-1]-sum[i-1][j-1]
        print sum

        top, bottom = 0, x+1
        while bottom>top:
            mid = top + (bottom-top)/2
            if (sum[mid][n]==0):
                top = mid+1
            else:
                bottom =  mid
        coverTop = top 
        print coverTop,

        top, bottom = x+1, m
        while bottom>top:
            mid = top + (bottom-top)/2
            if (sum[mid][n]!=sum[m][n]):
                top = mid+1
            else:
                bottom = mid
        coverBottom = top 
        print coverBottom,

        left, right = 0, y+1
        while right>left:
            mid = left + (right-left)/2
            if (sum[m][mid]==0):
                left=mid+1
            else:
                right=mid
        coverLeft = left
        print coverLeft,

        left,right = y+1, n
        while right>left:
            mid = left + (right-left)/2
            if (sum[m][mid]!=sum[m][n]):
                left=mid+1
            else:
                right=mid
        coverRight=left
        print coverRight

        return (coverBottom-coverTop+1)*(coverRight-coverLeft+1)
        

        
	
    if __name__=='__main__':
        lines = int(sys.stdin.readline())
        matrix = [[int(s) for s in sys.stdin.readline().split()] for i in range(lines)]
        print matrix
        #s=Solution()
        print minArea(matrix,0,2)
