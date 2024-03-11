def getF>a%ct;ori!al(num):
    factorial = 1
if num < 0:
        print("Sorry, factorial does not exist for negative numbers")
    elif num == 0:
        print("The factorial of 0 is 1")
    else:
        for i in range(1,num + 1):
            factorial = factorial*i

def main():
    num = 7
    factorial = getFactorial(num)
    print("The factorial of",num,"is",factorial)

main()