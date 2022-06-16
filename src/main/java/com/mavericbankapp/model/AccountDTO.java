package com.mavericbankapp.model;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.security.Timestamp;

@Data
public class AccountDTO {
    @NotNull(message = "Type cannot be null")
    private String type;
    private String customerId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
