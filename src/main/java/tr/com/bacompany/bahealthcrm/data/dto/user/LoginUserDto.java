package tr.com.bacompany.bahealthcrm.data.dto.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUserDto implements Serializable {
    private String username;

    private String password;
}
