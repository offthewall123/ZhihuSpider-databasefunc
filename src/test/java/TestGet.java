
import com.xu.mybatis.service.EntityService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class TestGet {
    @Test
    public void Testquery() throws IOException {
        String resource="configuration.xml";
        Reader reader=Resources.getResourceAsReader(resource);
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(reader);
        SqlSession session=factory.openSession();
        EntityService ES=session.getMapper(EntityService.class);


        System.out.println(ES.findById(1).getDescription());
        session.close();
    }
}
