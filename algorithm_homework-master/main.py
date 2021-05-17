import random

# Переменные размера матрицы
column = 10
row = 10

matrix = [[random.randrange(0, 100) for y in range(column)] for x in range(row)]


def quicksort(nums):
    if len(nums) <= 1:
        return nums
    else:
        q = random.choice(nums)
    l_nums = [n for n in nums if n < q]

    e_nums = [q] * nums.count(q)
    b_nums = [n for n in nums if n > q]
    return quicksort(l_nums) + e_nums + quicksort(b_nums)




