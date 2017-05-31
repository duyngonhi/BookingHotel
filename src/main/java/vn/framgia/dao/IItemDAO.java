package vn.framgia.dao;

import vn.framgia.bean.ItemBean;
import vn.framgia.model.Item;

import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 08/03/2017.
 *
 */
public interface IItemDAO extends IGenericDAO<Item, Integer> {
    public List<Item> findItemByName(String serviceName);
    public ItemBean getItemBeanById(Integer id);
    public Item getItemById(Integer id);
}
