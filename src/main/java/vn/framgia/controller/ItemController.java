package vn.framgia.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.framgia.bean.ItemBean;
import vn.framgia.model.Item;
import vn.framgia.service.IItemService;
import java.util.ArrayList;
import java.util.List;
import vn.framgia.model.Item;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by FRAMGIA\duong.van.tien on 08/03/2017.
 *
 */
@Controller
public class ItemController {
    public static final Logger logger = Logger.getLogger(ItemController.class);

    @Autowired
    IItemService itemService;

    @RequestMapping(value = "/new_item", method = RequestMethod.GET)
    public String addItem(Model model) {
        ItemBean itemBean = new ItemBean();
        model.addAttribute("itemBeanForm", itemBean);
        return "newItem";
    }

    @RequestMapping(value = "/new_item", method = RequestMethod.POST)
    public ModelAndView addItem(@ModelAttribute("itemBeanForm") ItemBean itemBean,
                                   BindingResult binding) {
        boolean checkAdd = true;
        checkAdd = itemService.addItem(itemBean);
        if(!checkAdd) {
            ModelAndView view = new ModelAndView();
            view.setViewName("newItem");
            view.addObject("err_AddItem", "add item - the error occurred");
            return view;
        }

        return new ModelAndView("redirect:items");
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ModelAndView showListItems(Model model, Integer offset, Integer maxResults) {
        ModelAndView view = new ModelAndView("items");
        List<ItemBean> listItemsBean = itemService.list(offset, maxResults);
        model.addAttribute("count", itemService.count());
        model.addAttribute("offset", offset);
        if(listItemsBean == null)
            view.addObject("listItemsBeanEmpty", "List items is empty");
        view.addObject("listItemsBean", listItemsBean);
        return view;
    }

    @RequestMapping(value = "/delete_item")
    public ModelAndView deleteItem(@RequestParam int id) {
        boolean check = true;
        check = itemService.deleteItem(id);
        if(check) {
            ModelAndView view = new ModelAndView();
            view.setViewName("items");
            view.addObject("err_DeleteItem", "Delete item - the error occurred");
            return view;
        }
        return new ModelAndView("redirect:items");
    }

    @RequestMapping(value = "/edit_item", method = RequestMethod.GET)
    public ModelAndView editService(@RequestParam int id) {
        ItemBean itemBean = itemService.getItemBeanById(id);
        if(itemBean == null) {
            ModelAndView view = new ModelAndView();
            view.setViewName("items");
            view.addObject("err_EditItem", "Edit item - the error occurred");
            return view;
        }
        ModelAndView view = new ModelAndView();
        view.addObject("itemBeanForm", itemBean);
        view.setViewName("editItem");
        return view;
    }

    @RequestMapping(value = "/update_item", method = RequestMethod.POST)
    public ModelAndView updateItem(@ModelAttribute("itemBeanForm") ItemBean itemBean) {
        boolean check = true;
        check  = itemService.updateItem(itemBean);
        if(!check) {
            System.out.println("-------------------");
            ModelAndView view = new ModelAndView();
            view.setViewName("editItem");
            view.addObject("err_UpdateItem", "Update item - the error occurred");
            return view;
        }
        return new ModelAndView("redirect:items");
    }

    @RequestMapping(value = "/search_item", method = RequestMethod.GET)
    public @ResponseBody List<Item> searchItem(@RequestParam(value = "itemName") String itemName) {
        List<Item> listItemBean = itemService.findItemByName(itemName);
        System.out.println(" size : "+listItemBean);
        ModelAndView view = new ModelAndView();
        if (listItemBean == null) {
            view.addObject("listRoomBeamEmpty", "Result is empty");
            view.setViewName("items");
            return new ArrayList<Item>();
        }
        return listItemBean;
    }
}
