package APIhomework;

import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUsersRequestData {
    private String name;
    private String gender;
    private String email;
    private String status;


}
