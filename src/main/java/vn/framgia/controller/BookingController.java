package vn.framgia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import vn.framgia.bean.*;
import vn.framgia.service.*;
import java.util.*;
import vn.framgia.bean.ShowBookingBean;
import vn.framgia.service.IBookingService;
import vn.framgia.util.Helpers;

@Controller
public class BookingController {

    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
    @Autowired
    private IBookingService bookingService;

    @Autowired
    private IClientService clientService;

    @Autowired
    private IRoomService roomService;

    @Autowired
    private IItemService itemService;

	@RequestMapping("/showbooking")
	public ModelAndView show(){
		logger.info("------show list booking by client");
		Map<String, Object> model = new HashMap<String, Object>();
		List<List<ShowBookingBean>> lstBookingBean = bookingService.findAllBookingOrderByDesc();
		model.put("listbooks", lstBookingBean);
		return new ModelAndView("showbooking", model);
	}
	
	@RequestMapping(value = "/searchbill", method = RequestMethod.POST)
	public ModelAndView searchBillByNameClient(@RequestParam(value="search") String search){
		logger.info("------search booking follow some addition client");
		Map<String, Object> model = new HashMap<String, Object>();
		if(Helpers.isEmpty(search)){
			search = "";
		}
		List<List<ShowBookingBean>> lstBookingBean = bookingService.searchBookingByNameClient(search);
		model.put("listbooks", lstBookingBean);
		return new ModelAndView("showbooking", model);
	}

    @RequestMapping(value = "/viewBooking", method = RequestMethod.GET)
    public ModelAndView viewBooking(Model model, Integer offset, Integer maxResults) {
        try {
            ModelAndView view = new ModelAndView();
            ConditionBookingBean conditionBookingBean = new ConditionBookingBean();
            model.addAttribute("conditionBookingBeanForm", conditionBookingBean);
            List<RoomBean> listRoomsBean = bookingService.listRooms(offset, maxResults);
            view.addObject("listRoomsBean", listRoomsBean);
            model.addAttribute("count", bookingService.countRoom());
            model.addAttribute("offset", offset);
            view.setViewName("viewBooking");
            return view;
        } catch (Exception e) {
            logger.error("Exception in function searchRoomCondition in BookingController : ", e);
        }
        return null;
    }

    @RequestMapping(value = "/searchRoomCondition", method = RequestMethod.POST)
    public ModelAndView searchRoomCondition(
        @ModelAttribute("conditionBookingBeanForm") ConditionBookingBean conditionBookingBean) {
        ModelAndView view = new ModelAndView();
        try {

            Integer size = conditionBookingBean.getSize();
            Date start = Helpers.convertStringtoDate(conditionBookingBean.getStartDate());
            Date end = Helpers.convertStringtoDate(conditionBookingBean.getEndDate());
            List<RoomBean> listRoomsBean = roomService.searchRoomCondition(start, end, size);
            if(listRoomsBean == null) {
                view.addObject("err_empty", "Can not find results by condition");
                listRoomsBean = roomService.findAllRooms();
                view.addObject("listRoomsBean", listRoomsBean);
                view.setViewName("viewBooking");
                return view;
            }
            conditionBookingBean.setStartDate(conditionBookingBean.getStartDate());
            conditionBookingBean.setEndDate(conditionBookingBean.getEndDate());
            conditionBookingBean.setSize(conditionBookingBean.getSize());
            view.addObject("conditionBookingBeanForm", conditionBookingBean);
            view.addObject("listRoomsBean", listRoomsBean);
            view.setViewName("searchRoom");
            return view;
        } catch (Exception e) {
            logger.error("Exception in function searchRoomCondition in BookingController : ", e);
        }
        return view;
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public ModelAndView bookingInfo(Model model, @ModelAttribute("roomBeanForm") RoomBean roomBeanForm,
            Integer offset, Integer maxResults) {
        ModelAndView view = new ModelAndView();
        try {
            Integer id = roomBeanForm.getId();
            RoomBean roomBean = roomService.getRoomBeanById(id);
            roomBean.setStart(roomBeanForm.getStart());
            roomBean.setEnd(roomBeanForm.getEnd());
            model.addAttribute("roomBeanForm", roomBean);
            ClientBean clientBean = new ClientBean();
            model.addAttribute("clientBeanForm", clientBean);
            List<ItemBean> listItemsBean = itemService.getAllItems();
            model.addAttribute("listItemsBeanForm", listItemsBean);
            BookingBean bookingBean = new BookingBean();
            model.addAttribute("bookingBeanForm", bookingBean);
            view.setViewName("booking");
            return view;
        } catch (Exception e) {
            logger.error("Exception in function searchRoomCondition in BookingController : ", e);
        }
        return view;
    }

    @RequestMapping(value = "/bookingAction", method = RequestMethod.POST)
    public ModelAndView bookingAction(@ModelAttribute("clientBeanForm") ClientBean clientBean,
          @ModelAttribute("roomBeanForm") RoomBean roomBean,
          @ModelAttribute("bookingBeanForm") BookingBean bookingBean, Model model) {
        try {
            ModelAndView view = new ModelAndView();
            Integer clientId = clientService.addClient(clientBean);
            clientBean.setId(clientId);
            if(clientId == null) {
                view.addObject("err_addClient", "Add client, the error occurred!");
                List<RoomBean> listRoomsBean = roomService.findAllRooms();
                view.addObject("listRoomsBean", listRoomsBean);
                ConditionBookingBean conditionBookingBean = new ConditionBookingBean();
                conditionBookingBean.setStartDate("");
                conditionBookingBean.setEndDate("");
                model.addAttribute("conditionBookingBeanForm", conditionBookingBean);
                view.setViewName("viewBooking");
                return view;
            }
            boolean check = bookingService.addBooking(bookingBean, clientBean, roomBean);
            if (!check) {
                List<RoomBean> listRoomsBean = roomService.findAllRooms();
                view.addObject("listRoomsBean", listRoomsBean);
                ConditionBookingBean conditionBookingBean = new ConditionBookingBean();
                conditionBookingBean.setStartDate("");
                conditionBookingBean.setEndDate("");
                model.addAttribute("conditionBookingBeanForm", conditionBookingBean);
                view.setViewName("viewBooking");
                view.addObject("err_addBooking", "Add booking, the error occurred!");
                return view;
            }
        } catch (Exception e) {
            logger.error("Exception at function bookingAction in BookingController : ", e);
        }
        return new ModelAndView("redirect:viewBooking");
    }

    @RequestMapping(value = "/statictical", method = RequestMethod.GET)
    public ModelAndView statictical(Model model) {
        try {
            ModelAndView view = new ModelAndView();
            ConditionBookingBean conditionBookingBean = new ConditionBookingBean();
            model.addAttribute("conditionBookingBeanForm", conditionBookingBean);
            view.setViewName("staticticalRevenue");
            return view;
        } catch (Exception e) {
            logger.error("Exception in function statictical in BookingController : ", e);
        }
        return null;
    }

    @RequestMapping(value = "/staticticalResult", method = RequestMethod.GET)
    public @ResponseBody List<Statistical> staticticalRevenue(
            @RequestParam(value = "startDateVal") String startDate, @RequestParam(value = "endDateVal") String endDate,
            @ModelAttribute("conditionBookingBeanForm") ConditionBookingBean conditionBookingBean) {
        ModelAndView view = new ModelAndView();
        try {
            Date start = Helpers.convertStringtoDate(startDate);
            Date end = Helpers.convertStringtoDate(endDate);
            List<Statistical> statisticalsList = bookingService.statisticRevenue(start, end);
            if(statisticalsList == null) {
                view.addObject("err_empty", "Can not find results by condition");
                List<RoomBean> listRoomsBean = roomService.findAllRooms();
                view.addObject("listRoomsBean", listRoomsBean);
                view.setViewName("viewBooking");
                return statisticalsList;
            }
            conditionBookingBean.setStartDate(conditionBookingBean.getStartDate());
            conditionBookingBean.setEndDate(conditionBookingBean.getEndDate());
            conditionBookingBean.setSize(conditionBookingBean.getSize());
            view.addObject("conditionBookingBeanForm", conditionBookingBean);
            view.addObject("statisticalsList", statisticalsList);
            view.setViewName("staticticalRevenue");
            return statisticalsList;
        } catch (Exception e) {
            logger.error("Exception in function staticticalRevenue in BookingController : ", e);
        }
        return null;
    }
}
