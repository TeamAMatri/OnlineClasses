def isLeapyear(y):
    if(y%400==0) or (y%4==0 and y%100!=0):
        return True
    return False

# to define the prime number
def isPrime(y):
    for i in range(2,y):
        if(y%i==0):
            return False
    return True