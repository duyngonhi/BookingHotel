package vn.framgia.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.framgia.bean.ActivityBean;
import vn.framgia.service.IActivityService;

@Controller
public class HomeController {
	private static final Logger logger = Logger.getLogger(HomeController.class);
	@Autowired
	private IActivityService activityService;
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        logger.info("Welcome index page! The client locale");

        return new ModelAndView("index");
    }
	
	@RequestMapping(value = "/activity")
	public @ResponseBody List<ActivityBean> showInforActivity(@RequestParam("page") Integer pageNumber){
		logger.info("-----------:call show activity"+pageNumber);
		List<ActivityBean> lstActivityBeans = activityService.getAllInforActivity(pageNumber);
		return lstActivityBeans;
	}
}
