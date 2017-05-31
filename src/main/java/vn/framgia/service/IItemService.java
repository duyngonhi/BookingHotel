package vn.framgia.service;

import vn.framgia.bean.ItemBean;
import vn.framgia.model.Item;
import java.io.Serializable;
import java.util.List;
import vn.framgia.model.Item;

/**
 * Created by FRAMGIA\duong.van.tien on 08/03/2017.
 *
 */
public interface IItemService extends Serializable {

    public List<ItemBean> getAllItems();
    public boolean addItem(ItemBean serviceBean);
    public boolean updateItem(ItemBean serviceBean);
    public boolean deleteItem(int id);
    public ItemBean getItemBeanById(int id);
    public List<Item> findItemByName(String seriveName);
    public List<ItemBean> list(Integer offset, Integer maxResults);
    public Integer count();
}
