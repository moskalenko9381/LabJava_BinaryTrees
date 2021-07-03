package binary_trees;

public class Elem {
    private Elem left;
    private Elem right;
    char data;

    Elem() {
        left = null;
        right = null;
        data = '\0';
    }

    Elem getLeft() {
        return left;        //возвращает значение левого поддерева
    }

    void setLeft(Elem l) {  //устанавливает левое поддерево
        left = l;
    }

    void setRight(Elem r) {     //устанавливает правое поддерево
        right = r;
    }

    Elem getRight() {           //возвращает значение правого поддерева
        return right;
    }

    char getData() {        //возвращает значение элемента
        return data;
    }

    void setData(char t) {       //устанавливает значение элемента
        data = t;
    }
}
