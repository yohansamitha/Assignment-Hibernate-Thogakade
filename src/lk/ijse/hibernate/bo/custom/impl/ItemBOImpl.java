package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.ItemBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.ItemDAO;
import lk.ijse.hibernate.dto.ItemDTO;
import lk.ijse.hibernate.entity.Item;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Item);

    @Override
    public boolean saveItem(ItemDTO itemDTO) throws Exception {
        return itemDAO.add(new Item(itemDTO.getItemID(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQty()));
    }
}
