#!/usr/bin/env python2
# coding: utf-8

import sys

def nthSuperUglyNumber(n, primes):
	length = len (primes)
	index = [0] * length
	result = [1]
	for t in range (n-1):
		minNum = min([primes[i] * result[index[i]] for i in range(length)])
		result.append(minNum)
		for i in range(length):
			if primes[i]*result[index[i]] == minNum:
				index[i] +=1
	return result[-1]

	
if __name__=='__main__':
	n = int(sys.stdin.readline())
	primes = [int(s) for s in sys.stdin.readline().split(" ")]
	print nthSuperUglyNumber(n, primes)


