import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int actualKit;
    private final int expectedKit;

    public FelineTest(int actualKit, int expectedKit){
        this.actualKit = actualKit;
        this.expectedKit = expectedKit;
    }
    @Parameterized.Parameters
    public static Object[][] getFelineTest() {
        return new Object[][]{
                {1, 1}, {2, 1}, {1, 3},
        };
    }

    @Test
    public void testEatMeat() throws Exception{
        Feline feline = new Feline();
        List<String> expectedFood = new ArrayList<>();
        expectedFood.add("Животные");
        expectedFood.add("Птицы");
        expectedFood.add("Рыба");
        Assert.assertEquals("Текст не совпадает", expectedFood, feline.eatMeat());
    }

    @Test
    public void testReturnTextFamily(){
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        Assert.assertEquals("Текст не совпадает", expectedFamily, feline.getFamily());
    }
    @Test
    public void testAmountKittensNotСonstructor(){
        Feline feline = new Feline();
        int expectedKittens = 1;
        Assert.assertEquals("Количество львят не совпадает", expectedKittens, feline.getKittens());
    }
    @Test
    public void testAmountKittensWithСonstructor(){
        Feline feline = new Feline();
        int actualKittens = actualKit;
        int expectedKittens = expectedKit;
        Assert.assertEquals("Количество львят не совпадает", expectedKittens, feline.getKittens(actualKittens));
    }
}
