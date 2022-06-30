package bye.itemservice.web.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class testController {

    @GetMapping("/testView")
    public ModelAndView testView() {
        ModelAndView mav = new ModelAndView("/test/testView");
        List<String> listMap = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < 10000; i++){
            listMap.add("0"+i);
            System.out.println("listMap!!! = " + listMap.get(i));
        }
        System.out.println("listMap!!!??? = " + listMap.size());
        System.out.println("listMap??? = " + listMap);
        mav.addObject("list", listMap);

        List<String> listMap1 = new ArrayList<>();

        for (int a = 0; a < 20000; a++) {
            if (a % 2 == 0) {

            }
        }


        return mav;
    }

}
