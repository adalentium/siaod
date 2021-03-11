import random
mat = [[random.randrange(0, 100) for y in range(1000)] for x in range(1000)]

import time
start_time = time.time()

def quicksort(nums):
    if len(nums) <= 1:
        return nums
    else:
        q = random.choice(nums)
    l_nums = [n for n in nums if n < q]

    e_nums = [q] * nums.count(q)
    b_nums = [n for n in nums if n > q]
    return quicksort(l_nums) + e_nums + quicksort(b_nums)


# Основной алгоритм сортировки кучей
def HeapSort(data):
    # Формируем первоначальное сортирующее дерево
    # Для этого справа-налево перебираем элементы массива
    # (у которых есть потомки) и делаем для каждого из них просейку
    for start in range((len(data) - 2) // 2, -1, -1):
        HeapSift(data, start, len(data) - 1)

        # Первый элемент массива всегда соответствует корню сортирующего дерева
    # и поэтому является максимумом для неотсортированной части массива.
    for end in range(len(data) - 1, 0, -1):
        # Меняем этот максимум местами с последним
        # элементом неотсортированной части массива
        data[end], data[0] = data[0], data[end]
        # После обмена в корне сортирующего дерева немаксимальный элемент
        # Восстанавливаем сортирующее дерево
        # Просейка для неотсортированной части массива
        HeapSift(data, 0, end - 1)
    return data


# Просейка свеху вниз, в результате которой восстанавливается сортирующее дерево
def HeapSift(data, start, end):
    # Начало подмассива - узел, с которого начинаем просейку вниз
    root = start

    # Цикл просейки продолжается до тех пор,
    # Пока встречаются потомки, большие чем их родитель
    while True:

        child = root * 2 + 1  # Левый потомок
        # Левый потомок за пределами подмассива - завершаем просейку
        if child > end: break

        # Если правый потомок тоже в пределах подмассива,
        # то среди обоих потомков выбираем наибольший
        if child + 1 <= end and data[child] < data[child + 1]:
            child += 1

        # Если больший потомок больше корня, то меняем местами
        # при этом больший потомок сам становится корнем,
        # от которого дальше опускаемся вниз по дереву
        if data[root] < data[child]:
            data[root], data[child] = data[child], data[root]
            root = child
        else:
            break

for i in range(row):
    print(HeapSort(matrix[i]))
print()
for i in range(row):
    print(quicksort(matrix[i]))
print()
for i in range(row):
    print(sorted(matrix[i]))

print("--- %s seconds ---" % (time.time() - start_time))