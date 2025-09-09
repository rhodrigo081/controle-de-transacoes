package org.example.model;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.TransactionType;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @DocumentId
    protected String id;
    protected Account accountSender;
    protected Account accountReceiver;
    protected LocalDateTime date;
    protected TransactionType type;
    protected Double value;

}
