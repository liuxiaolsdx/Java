package info.liuxiao;
/**
 * Created by Sean on 15/12/26.
 */
import info.liuxiao.BulbSwitcher;
import org.junit.Test;
import static org.junit.Assert.*;

public class BuldSwitcherTest {

    @Test
    public void testBuldSwitch (){
        assertEquals(3,new BulbSwitcher().buldSwitch(10));
        assertEquals(0,new BulbSwitcher().buldSwitch(0));
        assertEquals(1,new BulbSwitcher().buldSwitch(1));
        assertEquals(1,new BulbSwitcher().buldSwitch(3));
    }
}
