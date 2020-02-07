package collectionsAndMaps;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFilterRemove {
    public static void main(String[] args) {
        Item item1 = Item.builder().uuid(111).id(1).contents(new ArrayList<Content>(Arrays.asList(Content.builder().message("content1").build()))).build();
        Item item2a = Item.builder().uuid(222).id(2).contents(new ArrayList<Content>(Arrays.asList(Content.builder().message("content2a").build()))).build();
        Item item2b = Item.builder().uuid(333).id(2).contents(new ArrayList<Content>(Arrays.asList(Content.builder().message("content2b").build()))).build();
        Item item2c = Item.builder().uuid(444).id(2).contents(new ArrayList<Content>(Arrays.asList(Content.builder().message("content2c").build()))).build();
        Item item3 = Item.builder().uuid(555).id(3).contents(new ArrayList<Content>(Arrays.asList(Content.builder().message("content3").build()))).build();
        ArrayList<Item> items = new ArrayList<>(Arrays.asList(item1, item2a, item2b, item2c, item3));
        ArrayList<Item> filteredItems = new ArrayList<>();
        items.forEach(item -> rebuild(filteredItems, item));

        System.out.println("------------- items: ");
        items.forEach(it -> System.out.println("uuid: " + it.getUuid() + "id: " + it.getId() + ", contents: " + it.contentsToString()));
        System.out.println("------------- filteredItems: ");
        filteredItems.forEach(it -> System.out.println("uuid: " + it.getUuid() + "id: " + it.getId() + ", contents: " + it.contentsToString()));
    }
static void rebuild(List<Item> target, Item item) {
        if (target.size() == 0) target.add(item);
        else {
//            target.forEach(it -> {
//                if (it.getId().equals(item.getId())) it.getContents().addAll(item.getContents());
//                else target.add(item);
//            });
            if (target.contains(item)) target.get(target.indexOf(item)).getContents().addAll(item.getContents());
            else target.add(item);
        }
}


    @Getter
    @Setter
    @Builder
//    @AllArgsConstructor
    static class Item {
        Integer uuid;
        Integer id;
        ArrayList<Content> contents;
        String contentsToString() {
            String result = "";
            for (Content content : contents) result += content.getMessage() + ", ";
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) return false;
            return id.equals(((Item) obj).id);
        }
    }
    @Data
    @Builder
//    @AllArgsConstructor
    static class Content {
        String message;
    }
}
