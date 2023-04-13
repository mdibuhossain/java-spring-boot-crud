package app.web.mdibuhossain.crud.repository;

import app.web.mdibuhossain.crud.model.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, ObjectId> {
}
