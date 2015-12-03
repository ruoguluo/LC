#!/usr/bin/env python2
# coding: utf-8
import sys
class NumMatrix(object):
    def __init__(self, matrix):
        """
        initialize your data structure here.
        :type matrix: List[List[int]]
        """
        if len(matrix)==0:
            return
        m,n=len(matrix),len(matrix[0])
        global sum
        sum=[[0]*(n+1) for i in range(m+1)]
        for i in range(1,m+1):
            for j in range(1,n+1):
                sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+matrix[i-1][j-1]
                print "{0},{1}={2}".format(i,j,sum[i][j])
        print sum


    def sumRegion(self, row1, col1, row2, col2):
        """
        sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.
        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        return sum[row2+1][col2+1]-sum[row2+1][col1]-sum[row1][col2+1]+sum[row1][col1]

if __name__ == '__main__':
    rows=int(sys.stdin.readline())
    lines = [[int(s) for s in sys.stdin.readline().split()] for r in range(rows)]
    print lines
    numMatrix = NumMatrix(lines)
    print numMatrix.sumRegion(2,1,4,3)
    print numMatrix.sumRegion(1,1,2,2)
    print numMatrix.sumRegion(1,2,2,4)

