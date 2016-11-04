package org.bedoing.article;

import org.bedoing.DaoBoot;
import org.bedoing.entity.Article;
import org.bedoing.repository.ArticleRepository;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ken on 10/21/2016.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(classes = DaoBoot.class)
public class ArticleTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ArticleRepository articleRepository;

    @Before
    public void setUp() {

    }

    @Test
    public void testExample() throws Exception {
        Article a = articleRepository.findOne(1);

        System.out.println(a);

        Assert.assertEquals(a.getTitle(), "编译原理：求First集和Follow集");
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
