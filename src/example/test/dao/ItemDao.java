package example.test.dao;

import example.test.dto.ItemDto;

/**
 * Created by jaliya on 7/11/17.
 */

/**
 * providing an abstraction for the item related data
 */
public interface ItemDao {


    public ItemDto getItem(ItemDto itemDto);


}
