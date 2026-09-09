def fib(n):
    if n == 1 or n == 0:
        return n
    return fib(n-1) + fib(n-2)

print(fib(0)) 
print(fib(1))
print(fib(5))
print(fib(7)) 