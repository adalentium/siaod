from main import quicksort
from main import matrix, row

import time
start_time = time.time()


def selection_sort(lst):
    for num in range(len(lst)):
        min_value = num

        for item in range(num, len(lst)):
            if lst[min_value] > lst[item]:
                min_value = item

        lst[num], lst[min_value] = lst[min_value], lst[num]

    return lst

# Вызов функций сортировки
for i in range(row):
    print(selection_sort(matrix[i]))
# print()
# for i in range(row):
#     print(quicksort(matrix[i]))
# print()
# for i in range(row):
#     print(sorted(matrix[i]))

print("--- %s seconds ---" % (time.time() - start_time))