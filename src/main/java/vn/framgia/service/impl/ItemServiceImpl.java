package vn.framgia.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import vn.framgia.bean.ItemBean;
import vn.framgia.model.Item;
import vn.framgia.service.IItemService;
import vn.framgia.util.Helpers;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 08/03/2017.
 *
 */
public class ItemServiceImpl extends BaseserviceImpl implements IItemService {
    private static  final Logger logger = Logger.getLogger(ItemServiceImpl.class);


    @Override
    public List<ItemBean> getAllItems() {
        try {
            List<Item> listItems = itemDAO.findAll();
            if(!Helpers.isEmpty(listItems)) {
                List<ItemBean> listItemsBean = new ArrayList<ItemBean>();
                for(Item order : listItems) {
                    ItemBean itemBean = new ItemBean();
                    BeanUtils.copyProperties(order, itemBean);
                    listItemsBean.add(itemBean);
                }
                return listItemsBean;
            }
        } catch (Exception e) {
            logger.error("Exception in function getAllItems : ", e);
        }
        return null;
    }

    @Override
    public boolean addItem(ItemBean itemBean) {
        try {
            Item item = new Item();
            item.setName(itemBean.getName());
            item.setPrice(itemBean.getPrice());
            item.setDescription(itemBean.getDescription());
            itemDAO.save(item);
            return true;
        } catch (Exception e) {
            logger.error("Exception in function addItem : ", e);
        }
        return false;
    }

    @Override
    public boolean updateItem(ItemBean itemBean) {
        try {
            Item order = itemDAO.findById(itemBean.getId());
            order.setName(itemBean.getName());
            order.setPrice(itemBean.getPrice());
            order.setDescription(itemBean.getDescription());
            itemDAO.save(order);
            return true;
        } catch (Exception e) {
            logger.error("Exception in function updateItem : ", e);
        }
        return false;
    }

    @Override
    public boolean deleteItem(int id) {
        try {
            Item order = itemDAO.findById(id);
            itemDAO.delete(order);
            return true;
        } catch (Exception e) {
            logger.error("Exception in function deleteItem : ", e);
        }
        return false;
    }

    @Override
    public ItemBean getItemBeanById(int id) {
        try {
            Item item = itemDAO.findById(id);
            ItemBean itemBean = new ItemBean();
            itemBean.setId(id);
            itemBean.setName(item.getName());
            itemBean.setPrice(item.getPrice());
            itemBean.setDescription(item.getDescription());
            return itemBean;
        } catch (Exception e) {
            logger.error("Exception in function getItemBeanById : ", e);
        }
        return null;
    }

    @Override
    public List<Item> findItemByName(String itemName) {
        try {
            List<Item> list = itemDAO.findItemByName(itemName);
            return list;
        } catch (Exception e) {
            logger.error("Exception in function findItemByName (package service) : ", e);
        }
        return null;
    }

    @Override
    public List<ItemBean> list(Integer offset, Integer maxResults) {
        try {
            List<Item> listItems = itemDAO.list(offset, maxResults);
            if(!Helpers.isEmpty(listItems)) {
                List<ItemBean> listItemsBean = new ArrayList<ItemBean>();
                for(Item item : listItems) {
                    ItemBean itemBean = new ItemBean();
                    BeanUtils.copyProperties(item, itemBean);
                    listItemsBean.add(itemBean);
                }
                return listItemsBean;
            }
        } catch (Exception e) {
            logger.error("Exception at function list in ItemServiceImpl : ", e);
        }
        return null;
    }

    @Override
    public Integer count() {
        return itemDAO.count();
    }
}
