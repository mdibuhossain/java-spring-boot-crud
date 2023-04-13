package app.web.mdibuhossain.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String _id;
    private String book_name;
    private String author;
    private String edition;
    private String download_link;
    private String categories;
    private Boolean status;
    private String added_by;
    private String sub_categories;
}
