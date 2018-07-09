import models.Group;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static junit.framework.TestCase.assertEquals;

public class GroupTest {

    private ArrayList<String> names;
    private Group testGroup;

    @Before
    public void setUp() throws Exception {
        testGroup = new Group();
        this.names = new ArrayList<String>();
        names.add("Adri");
        names.add("Derek");
        names.add("Jack");
        names.add("Joe");
        names.add("Debi");
    }

    @Test
    public void canGetRandomGroup() {
        testGroup.addRandomMembersToGroup(names, 3);
        assertEquals(3, testGroup.getSize());
    }

}
