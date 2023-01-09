import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int expectedKittens;
    private final int actualKittens;


    public FelineTest(int expectedKittens, int actualKittens) {
        this.expectedKittens = expectedKittens;
        this.actualKittens = actualKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getFelineTest() {
        return new Object[][]{
                {1, 1}, {2, 1}, {1, 3},
        };
    }

    @Test
    public void shouldReturnPredator() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = new ArrayList<>();
        expectedFood.add("Животные");
        expectedFood.add("Птицы");
        expectedFood.add("Рыба");
        Assert.assertEquals("В методе eatMeat передается значение отличное от <Хищник>", expectedFood, feline.eatMeat());
    }

    @Test
    public void shouldCheckFamily() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        Assert.assertEquals("Наименование семейства не совпадает", expectedFamily, feline.getFamily());
    }

    @Test
    public void shouldCheckAmountKittens_NotConstructor() {
        Feline feline = new Feline();
        int expectedKittens = 1;
        Assert.assertEquals("Количество львят не совпадает", expectedKittens, feline.getKittens());
    }

    @Test
    public void shouldCheckAmountKittens_WithConstructor() {
        Feline feline = new Feline();
        Assert.assertEquals("Количество львят не совпадает", expectedKittens, feline.getKittens(actualKittens));
    }
}
