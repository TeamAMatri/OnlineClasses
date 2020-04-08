# code to check whether the given year is leap year or not
def isLeapyear(n):
    if(n%400==0) or (n%4==0 and n%100!=0):
        return True
    return False


# code to check whether the given number is prime or not
def isPrime(n):
    for i in range(2,n):
        if(n%i==0):
            return False
    return True
