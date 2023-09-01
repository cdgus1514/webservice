package dh.example.webservice.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired PostsRepository postsRepository;


    @After
    public void clean() {
        postsRepository.deleteAll();
    }


    @Test
    public void 게시글테스트() {

        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(
                Posts.builder()
                        .title(title)
                        .content(content)
                        .author("cdgus1514@gmail.com")
                        .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }


    @Test
    public void BaseTimeEntity_테스트() {

        // given
        LocalDateTime now = LocalDateTime.of(2023,9,1,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author").build());


        // when
        List<Posts> list = postsRepository.findAll();


        // then
        Posts posts = list.get(0);

        System.out.println("createdDate = " + posts.getCreatedDate() + ", modifiedDate = " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }


}