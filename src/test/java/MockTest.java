import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.yandex.practicum.Cat;
import ru.yandex.practicum.CatDog;
import ru.yandex.practicum.Dog;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @Mock
    private Cat cat;

    @Mock
    private Dog dog;

    @Test
    public void test() {
        // стаб, возвращающий половину кота с параметрами - 2 лапы, говорит "Я самый умный"
        Mockito.when(cat.createHalfCat()).thenReturn(new Cat(2, "Я самый умный"));
        // стаб, возвращающий половину пса с параметрами - 2 лапы, говорит "Я самый весёлый"
        Mockito.when(dog.createHalfDog()).thenReturn(new Dog(2, "Я самый весёлый"));

        Cat halfCat = cat.createHalfCat();
        Dog halfDog = dog.createHalfDog();
        CatDog catDog = new CatDog(halfCat, halfDog);
        // проверка, что у Котопса 4 лапы
        Assert.assertEquals(4, catDog.getLegsCount());
        // проверка, что Котопёс говорит "Единственный в мире малыш Котопёс"
        Assert.assertEquals("Единственный в мире малыш Котопёс", catDog.getSound());
    }
}
