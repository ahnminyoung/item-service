package bye.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //안에 component가 있음 그러면 component의 대상이됨
public class ItemRepository {

    // 스프링 컨테이너 안에서는 싱글톤 때문에 따로 static을 안써도된다고는 함

    /* 여러개가 동시에 store 에 접근하게되면 HashMap을 사용하면안됨 ItemRepository라는 객체는 싱글톤으로 생성이되고 static으로도 되어있음
        동시쓰레드가 동시에 접근해 그러면 hashMap을 사용하면안되고 사용하고싶으면 ConcurrenthashMap 써야함
    */
    private static final Map<Long, Item> store = new HashMap<>();   //static 사용 (static을 사용안하면 객체생성하는만큼 다른 스토어가 생성이됨)
    private static long sequence = 0L; //static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }

}
