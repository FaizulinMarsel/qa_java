import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private final String gender;
    private final int actualKitLion;
    private final int expectedKitLion;
    @Mock
    private Feline felineMock;

    public LionTest(String gender, int actualKitLion, int expectedKitLion) {

        this.gender = gender;
        this.actualKitLion = actualKitLion;
        this.expectedKitLion = expectedKitLion;
    }

    @Parameterized.Parameters
    public static Object[][] getLionTest() {
        return new Object[][]{
                {"Самец", 1, 1},
                {"Самка", 1, 2},
                {"Нечто", 3, 1},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(gender);
        Assert.assertTrue("В контструтор передано <Самка>. При передачи <Самка> переменная hasMane = false", lion.doesHaveMane());
    }

    @Test
    public void testGetFoodNotMockito() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline);
        List<String> expectedFood = new ArrayList<>();
        expectedFood.add("Животные");
        expectedFood.add("Птицы");
        expectedFood.add("Рыба");
        Assert.assertEquals("Текст не совпадает", expectedFood, lion.getFood());
    }


    @Test
    public void testGetFoodWithMockito() throws Exception {
        Lion lion = new Lion(felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Трава", "Различные растения"));
        List<String> expectedFood = new ArrayList<>();
        expectedFood.add("Трава");
        expectedFood.add("Различные растения");
        Assert.assertEquals("Текст не совпадает", expectedFood, lion.getFood());
    }

    @Test
    public void testGetKittensWithConstruktor() {
        Feline feline = new Feline();
        Lion lion = new Lion(feline);
        int actualKittens = actualKitLion;
        int expectedKittens = expectedKitLion;
        Assert.assertEquals("Количество львят не совпадает", expectedKittens, lion.getKittens(actualKittens));
    }
}
