package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.ItemDTO;

public interface ItemBO extends SuperBO {
    boolean saveItem(ItemDTO itemDTO) throws Exception;
}
