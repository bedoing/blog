package org.bedoing.article;

import org.bedoing.commonapplication.CommonApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ken on 10/21/2016.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
//@ComponentScan("org.bedoing")
@SpringBootTest(classes = CommonApplication.class)
public class ArticleTests {
//    @Autowired
//    private TestEntityManager entityManager;


    @Before
    public void setUp() {

    }

    @Test
    public void testExample() throws Exception {

    }


}
