package bye.itemservice.web.test;

import bye.itemservice.web.file.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    private FileService fileService;

    @GetMapping("/testView")
    public ModelAndView testView() {
        ModelAndView mav = new ModelAndView("/test/testView");
        List<String> listMap = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            listMap.add(String.valueOf(i));
//            System.out.println("listMap!!! = " + listMap.get(i));
        }
        System.out.println("listMap!!!??? = " + listMap.size());
        System.out.println("listMap??? = " + listMap);
        mav.addObject("list", listMap);

        List<Integer> listMap1 = new ArrayList<>();

        for (int a = 0; a < 20000; a++) {
            if (a % 4 == 0) {
                listMap.add(String.valueOf(a));
                System.out.println("listMap1!!!=" + listMap.get(a));
            }
        }


        return mav;
    }

    @GetMapping("echart")
    public ModelAndView echart(){
        ModelAndView mav = new ModelAndView("test/echart");

        return mav;
    }

    @GetMapping("highchart")
    public ModelAndView highchart(){
        ModelAndView mav = new ModelAndView("test/highchart");
    @GetMapping("chView")
    public ModelAndView chView() {
        ModelAndView mav = new ModelAndView("test/chView");

        return mav;
    }

    /**
     * 5?????? ????????????(?????????) ??????
     *
     * @return
     */
    @GetMapping("chView1")
    public ModelAndView chView1() {
        ModelAndView mav = new ModelAndView("test/chView1");
        System.out.println("chView1??????!!!!");
        return mav;
    }

    /**
     * 5 line ???????????? (?????????) ??????
     *
     * @return
     */
    @GetMapping("5line")
    public ModelAndView chView2() {
        ModelAndView mav = new ModelAndView("test/5line");
        System.out.println("5?????? ?????? ?????? ??????!!!!");
        return mav;
    }

    /**
     * ????????? ??????
     *
     * @return
     */
    @GetMapping("realTime")
    public ModelAndView realTime() {
        ModelAndView mav = new ModelAndView("test/realTime");
        System.out.println("????????? ?????? ??????!!!!");
        return mav;
    }

    /**
     * ????????? ??????
     *
     * @return
     */
    @GetMapping("dynamic")
    public ModelAndView dynamic() {
        ModelAndView mav = new ModelAndView("test/dynamic");
        System.out.println("????????? ?????? ??????!!!!");
        return mav;
    }

    @GetMapping("etc")
    public String etcView() {
        System.out.println("etc ??????!!!!");
        return "test/etc";
    }

    @GetMapping("callback")
    public String callback() {
        System.out.println("testController.callback");
        return "test/callback";
    }

    @GetMapping("textarea")
    public String textarea() {
        System.out.println("testController.textarea");
        return "test/textarea";
    }

    @PostMapping("textarea")
    public String addTextarea(RedirectAttributes redirectAttributes){

        return "redirect:/text/etc";
    }

}
