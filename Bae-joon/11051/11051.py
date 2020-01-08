import sys
input = sys.stdin.readline()
dp = [[0]*1000 for i in range(1000)]

def binomial_coefficient(n,k) :
    if k==n or k==0 :
        return 1
    elif dp[n][k] != 0 :
        return dp[n][k]
    else :
        dp[n][k] = (binomial_coefficient(n-1,k-1) + binomial_coefficient(n-1,k))%10007
        return dp[n][k]

if __name__ == "__main__":
    n,k = input.split()

    n= int(n)
    k =int (k)

    print(binomial_coefficient(n,k));