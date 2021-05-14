class BinarySearchMap:
    def __init__(self):
        self.data = [] # хранилище (key, value) значений

    def search(self, key):
        """ Поиск индекса (во всех случаях лучше левосторонний,
            чтоб insert вставлял по убыванию) """
        l = 0
        r = len(self.data)
        while l < r:
            m = (l + r) // 2
            if self.data[m][0] < key:
                l = m + 1
            else:
                r = m
        return l    
        
    def __setitem__(self, key, value):
        """ Добавить элемент """
        index = self.search(key)
        # если ключ уже есть в таблице, то надо заменить значение
        if index < len(self.data) and self.data[index][0] == key:
            self.data[index] = (key, value)
        else:
            # иначе добавляем новую запись
            self.data.insert(index, (key, value))
    
    def __delitem__(self, key):
        """ Удалить элемент """
        index = self.search(key)
        self.data.pop(index)
    
    def __getitem__(self, key):
        """ Получить элемент """
        index = self.search(key)
        found_key, val = self.data[index]
        # если найденный индекс выдает запрашиваемый ключ
        if found_key == key:
            return val
        raise KeyError()
