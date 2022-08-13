package APIhomework;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentsRequestData {
    @JsonProperty("post_id")
    private Integer postId;

    private String name;
    private String email;
    private String body;
}
