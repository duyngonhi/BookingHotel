package vn.framgia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.framgia.bean.HotelBean;
import vn.framgia.bean.RoomBean;
import vn.framgia.model.Hotel;
import vn.framgia.service.IHotelService;
import vn.framgia.service.IRoomService;
import vn.framgia.util.Helpers;

import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 07/03/2017.
 *
 */
@Controller
public class RoomController {
    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    private IRoomService roomService;

    @Autowired
    private IHotelService hotelService;

    @RequestMapping(value = "/new_room", method = RequestMethod.GET)
    public String index(Model model) {
        RoomBean roomBean = new RoomBean();
        model.addAttribute("roomBeanForm", roomBean);
        List<HotelBean> listHotelsBean = hotelService.findAllHotels();
        model.addAttribute("hotelBeanForm", listHotelsBean);
        return "newRoom";
    }

    @RequestMapping(value = "/new_room", method = RequestMethod.POST)
    public ModelAndView addRoom(Model model, @ModelAttribute(value = "roomBeanForm") RoomBean roomBean,
            @ModelAttribute(value = "hotelBeanForm") HotelBean hotelBean) {
        ModelAndView view = new ModelAndView();
        boolean check = true;
        if (Helpers.isEmpty(roomBean.getName())) {
            view.addObject("err_name", "- name is not empty");
            check = false;
        }
        if (roomBean.getPrice()==null) {
            view.addObject("err_price","- price is not empty");
            check = false;
        }
        if(roomService.getRoomByRoomName(roomBean.getName()) == null) {
            check = false;
        } else if (!roomService.getRoomByRoomName(roomBean.getName()).isEmpty()) {
            view.addObject("err_name_duplicate", "Duplicate room name");
            check = false;
        }
        if (!check) {
            RoomBean room = new RoomBean();
            model.addAttribute("roomBeanForm", room);
            List<HotelBean> listHotelsBean = hotelService.findAllHotels();
            model.addAttribute("hotelBeanForm", listHotelsBean);
            view.setViewName("newRoom");
            return view;
        }
        Hotel hotel = hotelService.getHotelById(hotelBean.getId());
        roomBean.setHotel(hotel);
        boolean checkAdd = true;
        checkAdd = roomService.addRoom(roomBean);
        if(!checkAdd) {
            List<RoomBean> listRoomsBean = roomService.findAllRooms();
            view.addObject("listRoomsBean", listRoomsBean);
            view.setViewName("newRoom");
            view.addObject("err_addRoom", "Add room, the error occurred!");
            return view;
        }
        return new ModelAndView("redirect:rooms");
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public ModelAndView showListRooms() {
        ModelAndView view = new ModelAndView("rooms");
        List<RoomBean> listRoomsBean = roomService.findAllRooms();
        if(listRoomsBean == null)
            view.addObject("err_listRoomIsEmpty", "List room is empty");
        else
            view.addObject("err_listRoomIsEmpty", "");
        view.addObject("listRoomsBean", listRoomsBean);
        return view;
    }

    @RequestMapping("/delete_room")
    public ModelAndView deleteRoom(Model model, @RequestParam int id) {
        boolean check = true;
        check = roomService.deleteRoom(id);
        if(!check) {
            model.addAttribute("err_deleteRoom", "Delete room, the error occurred!");
            return new ModelAndView("redirect:rooms");
        }
        return new ModelAndView("redirect:rooms");
    }

    @RequestMapping(value = "/edit_room", method = RequestMethod.GET)
    public ModelAndView editEmployee(Model model, @RequestParam int id) {
        RoomBean roomBean = roomService.getRoomBeanById(id);
        List<HotelBean> listHotelsBean = hotelService.findAllHotels();
        ModelAndView view = new ModelAndView();
        if(roomBean == null) {
            model.addAttribute("err_editRoom", "Edit room, the error occurred!");
            return new ModelAndView("redirect:rooms");
        }
        model.addAttribute("hotelBeanForm", listHotelsBean);
        model.addAttribute("roomBeanForm", roomBean);
        view.setViewName("editRoom");
        return view;
    }

    @RequestMapping(value = "/update_room", method = RequestMethod.POST)
    public ModelAndView updateEmployee(@ModelAttribute(value = "roomBeanForm") RoomBean roomBean,
            @ModelAttribute(value = "hotelBeanForm") HotelBean hotelBean) {
        ModelAndView view = new ModelAndView();
        boolean check = true;
        if (Helpers.isEmpty(roomBean.getName())) {
            view.addObject("err_name", "- name is not empty");
            check = false;
        }
        if (roomBean.getPrice()==null) {
            view.addObject("err_price","- price is not empty");
            check = false;
        }
        if (!check) {
            view.setViewName("editRoom");
            return view;
        }
        Hotel hotel = hotelService.getHotelById(roomBean.getHotelId());
        roomBean.setHotel(hotel);
        boolean checkUpdate = true;
        checkUpdate = roomService.udpateRoom(roomBean);
        if(!checkUpdate) {
            view.setViewName("editRoom");
            view.addObject("err_updateRoom", "Update room, the error occurred!");
            return view;
        }
        return new ModelAndView("redirect:rooms");
    }

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public ModelAndView showRoom(Model model, @RequestParam int id) {
        RoomBean roomBean = roomService.getRoomBeanById(id);
        ModelAndView view = new ModelAndView();
        if(roomBean == null) {
            model.addAttribute("err_showRoom", "Action show room, the error occurred!");
            List<RoomBean> listRoomsBean = roomService.findAllRooms();
            view.addObject("listRoomsBean", listRoomsBean);
            return new ModelAndView("redirect:rooms");
        }
        model.addAttribute("roomBeanForm", roomBean);
        view.setViewName("showRoom");
        return view;
    }
}
