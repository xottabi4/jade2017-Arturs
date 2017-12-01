package lv.vea.design.patterns.tasks.two.three.practice.shop;

import java.util.*;
import java.util.Map.Entry;

/**
 * Shop class extends ItemList.
 * Shop allows Customer to know if new items has been added (calling isNewItems()) since last getAllItems() call.
 *
 * @author Janis
 */
public final class Shop {

    private List<Item> items = new LinkedList<>();

    private Map<String, Boolean> watched = new HashMap<>();

    public boolean addItem(Item item) {
        if (items.add(item)) {
            resetWatched();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return all items
     *
     * @param customer - Customer in question
     * @return all items in the Shop
     */
    public List<Item> getAllItems(Customer customer) {

        // Sets true in hashmap watched indicating that Customer has viewed all new Items.
        watched.put(customer.getName(), true);
        return items;
    }

    private void resetWatched() {
        for (Entry<String, Boolean> pair : watched.entrySet()) {
            pair.setValue(false);
        }
    }

    /**
     * Customer can call this method to view if new Items has arrived in the Shop
     *
     * @param customer - Customer in question
     * @return true - if there are new Items in the Shop, false - if not
     */
    public boolean isNewItems(Customer customer) {
        if (watched.containsKey(customer.getName())) {
            return watched.get(customer.getName());
        } else
            return true;
    }


    public Item findItemByCode(String itemCode) {
        Optional<Item> foundItem = items.stream().filter(i -> itemCode.equals(i.getCode())).findFirst();
        if (foundItem.isPresent()) {
            return foundItem.get();
        }
        throw new RuntimeException("Can't find item with code " + itemCode);
    }
}
