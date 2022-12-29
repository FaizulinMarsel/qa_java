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

    @Test
    public  void testGetFoodNotMockito() throws Exception{
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> expectedFood = new ArrayList<>();
        expectedFood.add("Животные");
        expectedFood.add("Птицы");
        expectedFood.add("Рыба");
        Assert.assertEquals("Текст не совпадает", expectedFood, cat.getFood());
    }
    @Mock
    private Feline feline;

    @Test
    public void testGetFoodWithMokito() throws Exception{
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Трава","Различные растения"));
        List<String> expectedFood = new ArrayList<>();
        expectedFood.add("Трава");
        expectedFood.add("Различные растения");
        Assert.assertEquals("Текст не совпадает", expectedFood, cat.getFood());
    }
    @Test
    public void testReturnTextSound(){
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        Assert.assertEquals("Текст не совпадает",expectedSound,cat.getSound());
    }
}
