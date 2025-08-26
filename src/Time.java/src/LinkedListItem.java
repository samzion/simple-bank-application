package Time.java.src;

import java.util.ArrayList;
import java.util.List;

public class LinkedListItem {
    List<String> items = new ArrayList<>();
    int currentIndex = -1;

    public String getItemFromIndex(int i){
        return items.get(i);
    }
    public void addItem(String item){
        items.add(item);
    }
    public void addItemToIndex(int index, String item){
        items.add(index, item);
        if (index <= currentIndex){
            currentIndex++;
        }
    }

    public void removeItemFromIndex(int index){
        items.remove(index);
        if (index <= currentIndex){
            currentIndex--;
        }
    }
    public String getNextItem(){
        if(currentIndex == -1 || currentIndex == items.size()-1){
            currentIndex = 0;
        } else {
            currentIndex++;
        }
        return items.get(currentIndex);
    }
    public String getPrevItem(){
        if(currentIndex == -1 || currentIndex == 0){
            currentIndex = items.size()-1;
        } else {
            currentIndex--;
        }
        return  items.get(currentIndex);
    }

    public int searchItem(String item){
        return items.indexOf(item);
    }
}
