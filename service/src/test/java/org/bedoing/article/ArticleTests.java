package org.bedoing.article;

import org.bedoing.ServiceBoot;
import org.bedoing.entity.Article;
import org.bedoing.service.impl.ArticleService;
import org.bedoing.vo.ArticleVO;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
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
@SpringBootTest(classes = ServiceBoot.class)
public class ArticleTests {
//    @Autowired
//    private TestEntityManager entityManager;

    @Autowired
    private ArticleService articleService;

    @Before
    public void setUp() {

    }

    @Test
    public void testExample() throws Exception {
        ArticleVO a = articleService.findArticleById(1);

        System.out.println(a);

        Assert.assertEquals(a.getTitle(), "for title");
        Assert.assertEquals(a.getArticleType(), 1);
    }

    private Article getDefaultArticle() {
        Article a = new Article();
        a.setArticleId(999);
        a.setTitle("for test title");
        a.setArticleType(1);
        a.setSummary("summary ***");
        a.setContent("content ............");

        return a;
    }
}
