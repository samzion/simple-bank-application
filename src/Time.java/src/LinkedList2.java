package Time.java.src;

import java.util.ArrayList;
import java.util.List;

public class LinkedList2 {
    private int currentIndex = -1;
    private List<String> items = new ArrayList<>();

    public void addItemToList(String item){
        if(  currentIndex > -1 &&  currentIndex == items.size()-1 ){
            currentIndex++;
        }
        items.add(item);
    }

    public void addItemToList(int index, String item){
        if( currentIndex > -1 && index <= currentIndex ){
            currentIndex++;
        }
        items.add(index, item);
    }

    public void removeItemFromList(int index){
        if(currentIndex > -1 && index <= currentIndex ){
            currentIndex--;
        }
        items.remove(index);
    }

    public String getNextItem(){
        if (currentIndex == -1 || currentIndex == items.size()-1){
            currentIndex = 0;
        } else {
            currentIndex++;
        }
        return items.get(currentIndex);
    }

    public String getPreviousItem(){
        if (currentIndex == -1 || currentIndex == 0){
            currentIndex = items.size()-1;
        } else {
            currentIndex--;
        }
        return items.get(currentIndex);
    }

}
