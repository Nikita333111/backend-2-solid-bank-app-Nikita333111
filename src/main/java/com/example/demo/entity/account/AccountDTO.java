package com.example.demo.entity.account;

import com.example.demo.AccountType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    @NotNull(message = "choose right account type")
    private AccountType accountType;
}
