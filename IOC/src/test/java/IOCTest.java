import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.hhu.xy.pojo.*;

public class IOCTest {

    @Test
    public void main() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(context.getBean("hello",Hello.class));
    }
}
