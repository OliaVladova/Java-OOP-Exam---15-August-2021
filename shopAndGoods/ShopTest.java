package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;


public class ShopTest {

    private Shop shop;
    private Goods good;
    private Goods goodToAdd;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.shop = new Shop();
        this.good = new Goods("Doll", "F98A");
        this.goodToAdd = new Goods("Bear", "15FT");
        this.shop.addGoods("Shelves1", good);
    }
@Test(expected = UnsupportedOperationException.class)
    public void testShouldThrowExceptionWhenModifying(){
        this.shop.getShelves().clear();
}
@Test
public void testShouldReturnShelves(){
    Map<String, Goods> returned = this.shop.getShelves();
    Map<String, Goods> expected = new LinkedHashMap<>();
    expected.put("Shelves1", good);
    expected.put("Shelves2", null);
    expected.put("Shelves3", null);
    expected.put("Shelves4", null);
    expected.put("Shelves5", null);
    expected.put("Shelves6", null);
    expected.put("Shelves7", null);
    expected.put("Shelves8", null);
    expected.put("Shelves9", null);
    expected.put("Shelves10", null);
    expected.put("Shelves11", null);
    expected.put("Shelves12", null);
    Assert.assertEquals(expected,returned);
}
    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenAddingToNoExistingShelf() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves15",goodToAdd);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenAddingTakenShelf() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves1",goodToAdd);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testShouldThrowExceptionWhenAddingExistingGood() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves2",good);
    }
    @Test
    public void testShouldAddCorrectlyGood() throws OperationNotSupportedException {
        String returned = this.shop.addGoods("Shelves3",goodToAdd);
        String expected = "Goods: 15FT is placed successfully!";
        Assert.assertEquals(expected,returned);
    }
    @Test
    public void testShouldRemoveCorrectlyGood() throws OperationNotSupportedException {
        this.shop.addGoods("Shelves3",goodToAdd);
        String returned = this.shop.removeGoods("Shelves3",goodToAdd);
        String expected = "Goods: 15FT is removed successfully!";
        Assert.assertEquals(expected,returned);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenRemovingFromNoShelf(){
        this.shop.removeGoods("Shelves20",good);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWhenNoGoodsToBeRemoved(){
        this.shop.removeGoods("Shelves5",good);
    }@Test
    public void testShouldSetNullGoods() {
        shop.removeGoods("Shelves1", good);
        Goods emptySlot = shop.getShelves().get("Shelves1");
        Assert.assertNull(emptySlot);
    }

}