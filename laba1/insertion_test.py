from main import quicksort
from main import matrix, row

import time
start_time = time.time()

def insertion_sort(lst):
    for item in range(1, len(lst)):
        current_value = lst[item]
        position = item

        while position > 0 and lst[position - 1] > current_value:
            lst[position] = lst[position - 1]
            position -= 1
        lst[position] = current_value

    return lst

for i in range(row):
    print(insertion_sort(matrix[i]))
# print()
# for i in range(row):
#     print((quicksort(matrix[i])))
# print()
# for i in range(row):
#     print((sorted(matrix[i])))

print("--- %s seconds ---" % (time.time() - start_time))