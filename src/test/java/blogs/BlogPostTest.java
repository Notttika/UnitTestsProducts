package blogs;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import blogs.BlogPost;
import blogs.BlogPostType;
class BlogPostTest {
    @Test
    public void shouldCountSumOfNumbersInTheList() {
        // given
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5);

        // when
        long quantity = listOfNumbers.stream().mapToLong(e -> e).sum();
        //System.out.println(quantity);
        // then

        assertThat(quantity).isEqualTo(15L);
    }

    @Test
    public void shouldFilterAllNumbersGreaterThan5AndDividedBy2() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // when
        List<Integer> numbersGreaterThan5 = numbers.stream().filter(e -> e > 5).filter(e -> e % 2 == 0).collect(Collectors.toList());
        //System.out.println(numbersGreaterThan5);
        // then
        assertThat(numbersGreaterThan5).isEqualTo(Arrays.asList(6, 8));
    }

    @Test
    public void shouldMultiplyAndTransformIntoStringEachElement() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when
        List<String> multipliedNumbersAsString = numbers.stream().map(e -> String.valueOf(e * 2)).collect(Collectors.toList());
        // System.out.println(multipliedNumbersAsString);
        // then
        Assertions.assertThat(multipliedNumbersAsString).containsExactly("2", "4", "6", "8", "10");
    }

    @Test
    public void shouldCheckIfThereIsANumberGreaterThan4() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when
        boolean anyNumberGreaterThan4 = numbers.stream().anyMatch((e -> e > 4));
        // System.out.println(anyNumberGreaterThan4);
        // then
        assertThat(anyNumberGreaterThan4).isTrue();
    }

    @Test
    public void shouldCheckIfEachNumberIsEven() {
        // given
        List<Integer> numbers = Arrays.asList(2, 4, 6);

        // when
        boolean eachNumberIsEven = numbers.stream().anyMatch(e -> e % 2 == 0);
        // System.out.println(eachNumberIsEven);

        // then
        assertThat(eachNumberIsEven).isTrue();
    }

    @Test
    public void shouldSortTheList() {
        // given
        List<String> listOfWords = Arrays.asList("B", "A", "D", "E", "C");

        // when
        List<String> sortedList = listOfWords.stream().sorted().collect(Collectors.toList());
        //System.out.println(sortedList);
        // then
        Assertions.assertThat(sortedList).containsExactly("A", "B", "C", "D", "E");
    }

    @Test
    public void shouldReduceOnlyPositiveValuesToCalculateMultiplyThem() {
        // given
        List<BigDecimal> numbers = Arrays.asList(
                BigDecimal.valueOf(15),
                BigDecimal.valueOf(-8),
                BigDecimal.valueOf(10),
                BigDecimal.valueOf(-8.6),
                BigDecimal.valueOf(2));

        // when
        Optional<BigDecimal> reduced = numbers.stream().filter(e -> e.compareTo(BigDecimal.ZERO) > 0).reduce(BigDecimal::multiply);
       // System.out.println(reduced);

        // then
        assertThat(reduced.isPresent()).isTrue();
        assertThat(reduced.get()).isEqualByComparingTo("300");
    }

    @Test
    public void shouldGroupBlogPostsByTheirTypes() {
        // given
        List<BlogPost> posts = Arrays.asList(
                new BlogPost("News item 1", "Author 1", BlogPostType.NEWS, 15),
                new BlogPost("Tech review 1", "Author 2", BlogPostType.REVIEW, 5),
                new BlogPost("Programming guide", "Author 1", BlogPostType.GUIDE, 20),
                new BlogPost("News item 2", "Author 2", BlogPostType.NEWS, 35),
                new BlogPost("Tech review 2", "Author 1", BlogPostType.REVIEW, 15));

        // when
        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream().collect(Collectors.groupingBy(blogPost -> blogPost.getType()));
        // System.out.println(postsPerType);
        // then
        assertThat(postsPerType.get(BlogPostType.NEWS).size()).isEqualTo(2);
        assertThat(postsPerType.get(BlogPostType.GUIDE).size()).isEqualTo(1);
        assertThat(postsPerType.get(BlogPostType.REVIEW).size()).isEqualTo(2);
    }

    @Test
    public void shouldBeCollectedToMapWithBlogPostTitleAsKey() {
        // given
        List<BlogPost> posts = Arrays.asList(
                new BlogPost("News item 1", "Author 1", BlogPostType.NEWS, 15),
                new BlogPost("Tech review 1", "Author 2", BlogPostType.REVIEW, 5),
                new BlogPost("Programming guide", "Author 1", BlogPostType.GUIDE, 20),
                new BlogPost("News item 2", "Author 2", BlogPostType.NEWS, 35),
                new BlogPost("Tech review 2", "Author 1", BlogPostType.REVIEW, 15));

        // when
        Map<String, BlogPost> postPerTitle = posts.stream().collect(Collectors.toMap(blogPost -> blogPost.getTitle(), Function.identity()));
        //System.out.println(postPerTitle);
        // then
        assertThat(postPerTitle.get("News item 1").getTitle()).isEqualTo("News item 1");
        assertThat(postPerTitle.get("Tech review 1").getTitle()).isEqualTo("Tech review 1");
        assertThat(postPerTitle.get("Programming guide").getTitle()).isEqualTo("Programming guide");
        assertThat(postPerTitle.get("News item 2").getTitle()).isEqualTo("News item 2");
        assertThat(postPerTitle.get("Tech review 2").getTitle()).isEqualTo("Tech review 2");

    }
}