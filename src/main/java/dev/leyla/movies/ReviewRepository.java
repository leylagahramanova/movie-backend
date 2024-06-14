

package dev.leyla.movies;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}