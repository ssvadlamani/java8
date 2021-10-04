package com.core.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TestGroupby {
public static void main(String[] args) {
	
	
	BlogPost bp= new BlogPost();
	bp.setAuthor("AAAA");
	bp.setLikes(10);
	bp.setTitle("Good Daddy");
	bp.setType(BlogPostType.GUIDE);
	
	BlogPost bp1= new BlogPost();
	bp1.setAuthor("AAAA");
	bp1.setLikes(10);
	bp1.setTitle("Good Daddy");
	bp1.setType(BlogPostType.NEWS);
	BlogPost bp2= new BlogPost();
	bp2.setAuthor("AAAA");
	bp2.setLikes(10);
	bp2.setTitle("Good Daddy");
	bp2.setType(BlogPostType.GUIDE);
	BlogPost bp3= new BlogPost();
	bp3.setAuthor("AAAA");
	bp3.setLikes(10);
	bp3.setTitle("Good Daddy");
	bp3.setType(BlogPostType.NEWS);
	BlogPost bp4= new BlogPost();
	bp4.setAuthor("AAAA");
	bp4.setLikes(10);
	bp4.setTitle("Good Daddy");
	bp4.setType(BlogPostType.GUIDE);
	
	List<BlogPost> list = new ArrayList();
	list.add(bp);
	list.add(bp1);
	list.add(bp2);
	list.add(bp3);
	list.add(bp4);
	Map<BlogPostType, List<BlogPost>> postsPerType = list.stream()
			  .collect(Collectors.groupingBy(BlogPost::getType));
	
//	System.out.println(postsPerType);

	
	Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = list.stream()
			  .collect(Collectors.groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));
	
//	System.out.println(postsPerTypeAndAuthor);
	
	Map<BlogPostType, Set<BlogPost>> postsPerType1 = list.stream()
			  .collect(Collectors.groupingBy(BlogPost::getType, Collectors.toSet()));
	
//	System.out.println(postsPerType1);
	
	Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType = list.stream()
			  .collect(Collectors.groupingBy(BlogPost::getType,
					  Collectors.maxBy(Comparator.comparingInt(BlogPost::getLikes))));

//	System.out.println(maxLikesPerPostType);
	
	Map<BlogPostType, IntSummaryStatistics> likeStatisticsPerType = list.stream()
			  .collect(Collectors.groupingBy(BlogPost::getType, 
					  Collectors.summarizingInt(BlogPost::getLikes)));

//	System.out.println(likeStatisticsPerType);
	
	Map<BlogPostType, String> postsPerType2 = list.stream()
			  .collect(Collectors.groupingBy(BlogPost::getType, 
					  Collectors.mapping(BlogPost::getTitle, Collectors.joining(", ", "Post titles: [", "]"))));
	
	System.out.println(postsPerType2);
}
}
