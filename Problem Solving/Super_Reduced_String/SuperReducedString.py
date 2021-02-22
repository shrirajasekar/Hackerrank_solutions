#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the superReducedString function below.
def superReducedString(s):
    for (i,x) in enumerate(s):
        if(s[i]==s[i+1] and i<len(s)):
            if(i==0):
                s=s[2:]
            elif(i+2 < len(s)):
                s=s[0:i]+s[i+2:]
            else:
                s=s[0:i]

    return "Empty String" if s=="" else s



if __name__ == '__main__':
    # fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = superReducedString(s)

    # fptr.write(result + '\n')

    # fptr.close()
