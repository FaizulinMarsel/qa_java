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

    public LionTest(String gender, int expectedKitLion, int actualKitLion) {

        this.gender = gender;
        this.expectedKitLion = expectedKitLion;
        this.actualKitLion = actualKitLion;
    }

    @Parameterized.Parameters
    public static Object[][] getLionTest() {
        return new Object[][]{
                {"Самец", 1, 1},
                {"Самка", 1, 2},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCheckHaveMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(gender, feline);
        Assert.assertTrue("В контструтор передано <Самка>. При передачи <Самка> переменная hasMane = false", lion.doesHaveMane());
    }

    @Test
    public void shouldHandleExceptionAndCheckText() throws Exception {
        Feline feline = new Feline();
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion("Нечто", feline);
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void shouldReturnFoodPredator_Lion() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        List<String> expectedFood = new ArrayList<>();
        expectedFood.add("Животные");
        expectedFood.add("Птицы");
        expectedFood.add("Рыба");
        Assert.assertEquals("В методе getFood передается значение отличное от <Хищник>", expectedFood, lion.getFood());
    }


    @Test
    public void shouldCompareTextIfPassedHerbivore_Mockito_Lion() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Трава", "Различные растения"));
        List<String> expectedFood = new ArrayList<>();
        expectedFood.add("Трава");
        expectedFood.add("Различные растения");
        Assert.assertEquals("Текст не совпадает", expectedFood, lion.getFood());
    }

    @Test
    public void shouldCheckKittens() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        Assert.assertEquals("Количество львят не совпадает", expectedKitLion, lion.getKittens(actualKitLion));
    }
}
