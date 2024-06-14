package dev.leyla.movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
@Service
public class ReviewService {
    private final MongoTemplate mongoTemplate;
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(MongoTemplate mongoTemplate, ReviewRepository reviewRepository) {
        this.mongoTemplate = mongoTemplate;
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }
}
//    private MongoTemplate mongogoTemplate;
//    public Review createReview(String reviewBody, String imdbId) {
//        Review review = new Review(reviewBody);
//        reviewRepository.insert(review);
//        mongoTemplate.update(Movie.class)
//                .matching(Criteria.where (key. "indbId").is(imdbId))
//    }
//}