package binary_trees;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner console = new Scanner(System.in);
        String input = "";
        String fileName;

        System.out.println("Выберите:\n1. Ввод списка с консоли\n2. Ввод списка с файла");
        int choice = console.nextInt();

        if (choice == 1) {
                System.out.println("Введите запись дерева в виде строки, где '/' - пустой элемент:");
                input = console.next();
                System.out.println(input + "*");
            }
        else if (choice == 2){
                System.out.println("Введите полный путь до файла:");
                fileName = console.next();
                File file = new File(fileName);
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    if (scanner.hasNextLine()) {
                        input = scanner.nextLine();
                    } else {
                        scanner.next();
                    }
                }
            }
        else {
                System.out.println("Вы должны ввести 1 или 2");
                return;
            }



        if (2*count(input, '/') - input.length() != 1 || input.charAt(0) == '/') {  //проверка на то, что '/' на одну больше, чем остальных символов
            System.out.println("Данные некорректны");
            return;
        }

        Elem root = readBT(input);
        System.out.println("Введенное дерево: ");
        recTreePrint(root);
        System.out.println();
        SimpleList head = new SimpleList();
        treePrint(head,root);
        head.listPrint();
    }





    static void recTreePrint(Elem node) {
        if (node == null) {
            System.out.print('/');
            return;
        }
        System.out.print(node.getData());
        recTreePrint(node.getLeft());      //печать левого
        recTreePrint(node.getRight());     //печать правого
    }

    static Elem readBT(String input){
        char sign = input.charAt(Index.readIndex);
        Index.readIndex++;
        if (sign == '/'){        //если элемент пустой
            return null;
        }
        else{
            Elem buf = new Elem();   //если нет, создаем листок
            buf.setData(sign);
            buf.setLeft(readBT(input));
            buf.setRight(readBT(input));
            return buf;
        }
    }

    static int count(String str, char c){     //подсчет конкретного символа в строке

        int count = str.length() - str.replace("" + c, "").length();
        return count;
    }

    static void treePrint(SimpleList head, Elem tree) {
        if (tree != null) { //Пока не встретится пустой узел
            SimpleList p = head.checkSimple(tree.getData());
            if (p == null) {
                if (head.data == '\0') {
                    System.out.println("Головой вспомогательного линейного списка будет " + tree.getData());
                    head.initHead(tree.getData());
                }
                else
                    head.push(tree.getData());
            }
            treePrint(head, tree.getLeft()); //Рекурсивная функция для левого поддерева
            treePrint(head, tree.getRight()); //Рекурсивная функция для правого поддерева
        }
    }

}
