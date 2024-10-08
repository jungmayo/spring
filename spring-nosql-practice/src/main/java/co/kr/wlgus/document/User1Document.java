package co.kr.wlgus.document;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "user1")
public class User1Document {
    @Id
    private String _id;


    private String uid;
    private String name;
    private int age;
    private String addr;
}
