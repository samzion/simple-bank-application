package Time.java.src;

import java.util.List;

public class TestLinkedList2 {
    public  static void main(String[] args){
        LinkedList2 cityLink =  new LinkedList2();
        LinkedList2 cityLink2 = new LinkedList2();

        cityLink.addItemToList("Yaba");
        cityLink.addItemToList("MaryLand");
        System.out.println(cityLink.getPreviousItem());
        cityLink.addItemToList("Ikeja");
        System.out.println(cityLink.getNextItem());
        cityLink.addItemToList("Oshodi");
        cityLink.addItemToList("Mushin");
        System.out.println(cityLink.getNextItem());
        System.out.println(cityLink.getNextItem());
        System.out.println(cityLink.getNextItem());
        System.out.println(cityLink.getPreviousItem());

        cityLink2.addItemToList("Yaba");
        cityLink2.addItemToList("Oshodi");
        cityLink2.addItemToList("Iyana Ipaja");
        cityLink2.addItemToList("Egbeda");
        cityLink2.addItemToList("Ikotun");
//        cityLink2.addItemToList("Oshodi");
//        cityLink2.addItemToList("Mushin");

        if (getSizeofLinkedList(cityLink) == getSizeofLinkedList(cityLink2)){
            System.out.println("The two linked lists are of same length");
        } else System.out.println("The two linked lists are not of same length");
//        for(int i = 0; i<20; i++){
//            System.out.println(cityLink.getPreviousItem());
//        }

        String searchString = "Ikotun";
        System.out.printf("The index of %s in cityLink2 is: %d", searchString, indexDifferenceFromCurrentItem(cityLink2, searchString));
    }

    public static int getSizeofLinkedList(LinkedList2 linkedList){

        String startItem= linkedList.getNextItem();
        int count = 1;

        while(true){
            String currentItem = linkedList.getNextItem();
            if(startItem.equals(currentItem)){
                break;
            }
            count++;
        }
        return count;
    }

    public static int indexDifferenceFromCurrentItem(LinkedList2 linkedList, String  item) {

        String currentItem = "";
        int sizeOfLinkedList = getSizeofLinkedList(linkedList);
        for(int i= 0; i < sizeOfLinkedList; i++){
            currentItem = linkedList.getNextItem();
            if (item.equals(currentItem)){
                return i+1;
            }
        }
        return -1;
    }
}
