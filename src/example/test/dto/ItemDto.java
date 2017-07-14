package example.test.dto;

/**
 * Created by jaliya on 7/10/17.
 */

/**
 * encapsulation of item data
 */
public class ItemDto {

    private String itemNumber;
    private String itemName;
    private String itemType;

    /**
     * set the value for itemNumber
     *
     * @param itemNo
     */
    public void setItemNumber(String itemNo) {

        this.itemNumber = itemNo;
    }

    /**
     * set the value for itemName
     *
     * @param itemName
     */
    public void setItemName(String itemName) {

        this.itemName = itemName;
    }

    /**
     * set the value for itemType
     *
     * @param itemType
     */
    public void setItemType(String itemType) {

        this.itemType = itemType;
    }

    /**
     * .return the value of itemNumber
     *
     * @return itemNumber
     */
    public String getItemNumber() {
        return this.itemNumber;
    }

    /**
     * return the value of itemName
     *
     * @return itemName
     */
    public String getItemName() {

        return this.itemName;
    }

    /**
     * return the value of itemType
     *
     * @return itemType
     */
    public String getItemType() {

        return this.itemType;
    }


}
