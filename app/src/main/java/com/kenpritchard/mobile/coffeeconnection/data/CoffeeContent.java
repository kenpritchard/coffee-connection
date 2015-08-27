package com.kenpritchard.mobile.coffeeconnection.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class CoffeeContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<CoffeeShop> ITEMS = new ArrayList<CoffeeShop>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, CoffeeShop> ITEM_MAP = new HashMap<String, CoffeeShop>();

    static {
        // Add 3 sample items.
        addItem(new CoffeeShop(
                "1",
                "Chuckeyta's Cafe",
                "411 Flagler Ave",
                "New Smyrna Beach, FL 32169",
                "(386) 428-2020",
                "It's located in the building that used to house Nichols Surf Shop which just moved to a little building " +
                        "next door. There are surfboards and other related items in the eclectic decor and the beach is just a couple " +
                        "blocks away. Awesome atmosphere here."
        ));
        addItem(new CoffeeShop(
                "2",
                "Caffe Di Riverwalk",
                "225 W Seminole Blvd #160",
                "Sanford, FL 32771",
                "(407) 287-5681",
                "As the name implies, it's located on the St. John's river right on the Sanford " +
                        "Riverwalk trail. They've got really good food and coffee."
        ));
        addItem(new CoffeeShop(
                "3",
                "Black Point Cafe",
                "882 North Point St",
                "San Francisco, CA 94109",
                "(415) 800-8448",
                "Black Point is located nearly in the middle of the tourist district but has a distinct " +
                        "local feel and great coffee. The rustic wood timber on a steep hill creates a very " +
                        "sinteresting setting."
        ));
    }

    private static void addItem(CoffeeShop item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class CoffeeShop {
        public String id;
        public String name;
        public String addr1;
        public String addr2;
        public String phone;
        public String content;

        public CoffeeShop(String theId, String theName, String theAddr1, String theAddr2, String thePhone, String theContent) {
            this.id = theId;
            this.name = theName;
            this.addr1 = theAddr1;
            this.addr2 = theAddr2;
            this.phone = thePhone;
            this.content = theContent;
        }

        public String getDetails() {
            return String.format("%s%n%s%n%s%n%s%n%n%s", name, addr1, addr2, phone, content);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
