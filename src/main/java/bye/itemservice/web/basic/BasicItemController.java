package bye.itemservice.web.basic;

import bye.itemservice.domain.item.Item;
import bye.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor    //롬복꺼임 (( final 붙은애를 가지고 생성자를 만들어줌
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }

//    @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam Integer quantity,
                       Model model){
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);

        model.addAttribute("item", item);

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item){
        /* ModelAttribute 가 자동으로 이것들을 만들어줌
            Item item = new Item();
            item.setItemName(itemName);
            item.setPrice(price);
            item.setQuantity(quantity);
        */
        itemRepository.save(item);
        // @ModelAttribute("item") 하면 밑에 model도 없애줘도됨 자기가 model 넣어주는 역할까지 수행함 밑에를 자동추가, 생략가능
//        model.addAttribute("item", item);

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item){
        /*
            Item 객체가 -> item 으로 변환되어 model.addAttribute("item") 키 값으로 들어감
                ex) @ModelAttribute HelloData item
                    HelloData -> helloData
                    model.addAttribute("helloData", item);
                    으로 됨
        */

        itemRepository.save(item);

        return "basic/item";
    }

    @PostMapping("/add")
    public String addItemV4(Item item){
        // @ModelAttribute를 빼도 우리가 만든 임의의 객체(dto, vo)에는 적용이됨
        itemRepository.save(item);

        return "basic/item";
    }

    /**
     *  테스트용 데이터 추가
     */
    @PostConstruct
    public void init(){
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }
}
