package Time.java.src;

public class DataStructure {
    public  static void main(String[] args){
        LinkedListItem cityLink = new LinkedListItem();
        cityLink.addItem("Yaba");
        cityLink.addItem("MaryLand");
        cityLink.addItem("Ikeja");
        cityLink.addItem("Oshodi");
        cityLink.addItem("Mushin");

        System.out.println(cityLink.getNextItem());
        System.out.println(cityLink.getNextItem());
        cityLink.addItemToIndex(1, "Fadeyi");
        System.out.println(cityLink.getPrevItem());
        System.out.println(cityLink.getPrevItem());
        System.out.println(cityLink.getPrevItem());
        System.out.println(cityLink.getPrevItem());
//        for(int i = 0; i < 20; i++ ){
//
//            if (i == 2){
//                cityLink.addItemToIndex(i, "BeforeIkeja");
//            }
//            System.out.println(cityLink.getNextItem());
//        }
//        System.out.println();
//        int index = cityLink.searchItem("Ikeja");
//        if(index == -1){
//            System.out.println("Cannot find item");
//        } else {
//            System.out.printf("Index of item is %d ",index );
//
//        }

    }
}

