import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline felineMock;

    @Test
    public void shouldReturnFoodPredator_Cat() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> expectedFood = new ArrayList<>();
        expectedFood.add("Животные");
        expectedFood.add("Птицы");
        expectedFood.add("Рыба");
        Assert.assertEquals("В методе getFood передается значение отличное от <Хищник>", expectedFood, cat.getFood());
    }


    @Test
    public void shouldCompareTextIfPassedHerbivore_Mockito_Cat() throws Exception {
        Cat cat = new Cat(felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Трава", "Различные растения"));
        List<String> expectedFood = new ArrayList<>();
        expectedFood.add("Трава");
        expectedFood.add("Различные растения");
        Assert.assertEquals("Текст не совпадает", expectedFood, cat.getFood());
    }

    @Test
    public void shouldCheckSoundCat() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        Assert.assertEquals("Звук не совпадает", expectedSound, cat.getSound());
    }
}
