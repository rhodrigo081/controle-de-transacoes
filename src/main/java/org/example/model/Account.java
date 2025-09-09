package org.example.model;


import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.AccountType;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @DocumentId
    protected String id;
    protected String ownerName;
    protected String ownerCPF;
    protected String password;
    protected AccountType type;
    protected List<PixKey> pixKey;
    protected Double balance;
    protected List<Transaction> transactions;
}
