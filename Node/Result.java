package Node;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Result {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<Integer>();
        List<Integer> collection = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Integer[] array = {25,26,27,28,29,30};
        List<Integer> collection1 = Arrays.asList(10,11,12,13,14,15,16);
        list.addHeadArray(array);



        System.out.println("Все содержимое");

        for (Integer a: list) {
            System.out.println(a);
        }

        System.out.println("_______");

        System.out.println("Все содержимое в обратном порядке");
        list.setReverse(true);
        for (Integer a: list) {
            System.out.println(a);
        }

        System.out.println("_______");

        System.out.println("Все содержимое от головы до заданного значения");

        list.setReverse(false);
        for (Integer a: list) {
            System.out.println(a);
            if(a==28) break;
        }

        System.out.println("_______");

        System.out.println("Все содержимое от хвоста до заданного значения");

        list.setReverse(true);
        for (Integer a: list) {
            System.out.println(a);
            if(a==28) break;
        }
        System.out.println("_______");

        System.out.println("Все содержимое от заданного значения до головы");
        list.setReverse(true);
        Iterator <Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if(iterator.next()==28) {
                iterator.forEachRemaining(System.out::println);
            }
        }

        System.out.println("_______");

        System.out.println("Все содержимое от заданного значения до хвоста");
        list.setReverse(false);
        Iterator <Integer> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            if(iterator1.next()==28) {
                iterator1.forEachRemaining(System.out::println);
            }
        }




/*

        for (Integer a: list) {
            if (a==null) break;
            System.out.println(a);
        }

        Iterator<Integer> iterator =  list.iterator();
        while (iterator.hasNext()){
            if(iterator.next() == 5) {
                iterator.forEachRemaining(System.out::println);
            }
        }

        /*
        list.addTailCollection(collection);
        list.listPrint();
        System.out.println("_____");
        list.replaceList(collection, collection1);
        list.listPrint();
        System.out.println("_____");
        list.addHeadArray(array);
        list.listPrint();
         */
    }
}
