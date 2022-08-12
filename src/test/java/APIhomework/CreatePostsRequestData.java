package APIhomework;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostsRequestData {
    @JsonProperty("user_id")
    private Integer userId;
    private String title;
    private String body;


}
