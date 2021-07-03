package binary_trees;

class SimpleList {
    char data;
    SimpleList next;
    int countH;

    SimpleList() {
        data = '\0';
        next = null;
        countH = 1;
    }

    SimpleList(char sign, SimpleList elem, int count) {
        data = sign;
        next = elem;
        countH = count;
    }

    void initHead(char sign)
    {
        data = sign;            // инициализация головы линейного списка
    }

    void push(char sign) {
        System.out.println("Добавляем " + sign + " в линейный список");
        SimpleList current = this;

        while (current.next != null)         //пока не достигнем конца списка
            current = current.next;

        current.next = new SimpleList(sign, null, 1);
    }

    void listPrint() {
        System.out.println("Посчитаем количество повторений каждого элемента в дереве");
        SimpleList p = this;
        do {
            System.out.println("В бинарном дереве элемент " + p.data + " повторяется "); // вывод значения элемента p
            System.out.println(p.countH + " раз");
            if (p.countH > 1) {
                System.out.println("Обнаружен повтор элемента " + p.data);
                Index.countSame++;
            }
            p = p.next; // переход к следующему узлу
        } while (p != null);
        if (Index.countSame == 0)
            System.out.println("В дереве нет одинаковых элементов");
        else
            System.out.println("В дереве " + Index.countSame  + " одинаковых элементов разных видов");
    }

    SimpleList checkSimple(char sign){
        SimpleList p = this;
        do {
            if (p.data == sign) {
                p.countH++;          //если в линейном списке уже есть такой элемент, то его количество увеличивается на 1
                return p;
            }
            p = p.next; // переход к следующему узлу
        } while (p != null);
        return null;
    }

}