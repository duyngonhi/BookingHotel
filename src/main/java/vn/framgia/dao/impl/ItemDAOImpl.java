package vn.framgia.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import vn.framgia.bean.ItemBean;
import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IItemDAO;
import vn.framgia.model.Item;

import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 08/03/2017.
 *
 */
public class ItemDAOImpl extends GenericDAO<Item, Integer> implements IItemDAO {
    private static final Logger logger = Logger.getLogger(ItemDAOImpl.class);
    public ItemDAOImpl() {
        super.setPersistentClass(Item.class);
    }

    @Override
    public List<Item> findItemByName(String itemName) {
        if(itemName.isEmpty()) {
            return null;
        }
        Criteria criteria = getSession().createCriteria(Item.class, "item");
        criteria.add(Restrictions.like("name","%"+itemName+"%"));
        List<Item> list = criteria.list();
        for (Item item:list){
            item.setBookings(null);
        }
        return list;
    }

    @Override
    public ItemBean getItemBeanById(Integer id) {
        try {
            Item item = findById(id);
            ItemBean itemBean = new ItemBean();
            itemBean.setId(item.getId());
            itemBean.setName(item.getName());
            itemBean.setPrice(item.getPrice());
            itemBean.setDescription(item.getDescription());
            return itemBean;
        } catch (Exception e) {
            logger.error("Exception at function getItemBeanById in class ItemServiceImpl : ", e);
        }
        return null;
    }

    @Override
    public Item getItemById(Integer id) {
        try {
            return findById(id);
        } catch (Exception e) {
            logger.error("Exception at function getItemById in class ItemServiceImpl : ", e);
        }
        return null;
    }
}
