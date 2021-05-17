from main import quicksort
from main import matrix, row

import time
start_time = time.time()


# Функция сортировки Шелла с созданеим матрицы внутри
# def shell_sort(row, column):
#     matrix = [[random.randrange(0, 100) for y in range(column)] for x in range(row)]
#
#     for i in range(row):
#         gap = column // 2
#         while gap > 0:
#             for value in range(gap, column):
#                 current_value = matrix[i][value]
#                 position = value
#
#                 while position >= gap and matrix[i][position - gap] > current_value:
#                     matrix[i][position] = matrix[i][position - gap]
#                     position -= gap
#                     matrix[i][position] = current_value
#
#             gap //= 2
#         print(matrix[i])

# shell_sort(10, 10)


def shell_sort(lst):
    gap = len(lst) // 2

    while gap > 0:
        for value in range(gap, len(lst)):
            current_value = lst[value]
            position = value

            while position >= gap and lst[position - gap] > current_value:
                lst[position] = lst[position - gap]
                position -= gap
                lst[position] = current_value

        gap //= 2
    return lst


# for i in range(row):
#     print(quicksort(matrix[i]))
# print()
for i in range(row):
    print(shell_sort(matrix[i]))
# print()
# for i in range(row):
#     print(sorted(matrix[i]))

print("--- %s seconds ---" % (time.time() - start_time))