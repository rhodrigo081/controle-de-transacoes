package org.example.repository;

import com.google.cloud.firestore.*;
import org.example.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ExecutionException;
import com.google.api.core.ApiFuture;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private final Firestore fireStore;
    private final CollectionReference accountCollection;

    @Autowired
    public AccountRepositoryImpl(Firestore fireStore) {
        this.fireStore = fireStore;
        this.accountCollection = fireStore.collection("accounts");
    }

    @Override
    public Account createAccount(Account account) throws ExecutionException, InterruptedException {
        DocumentReference docRef = accountCollection.document();
        account.setId(docRef.getId());

        ApiFuture<WriteResult> result = docRef.set(account);
        result.get();

        return account;
    }

    @Override
    public Account findByPixKey(String pixKey) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> query = accountCollection
                .whereEqualTo("pixKey", pixKey)
                .get();

        List<QueryDocumentSnapshot> documents = query.get().getDocuments();

        if (!documents.isEmpty()) {
            return documents.get(0).toObject(Account.class);
        }
        return null;
    }

    @Override
    public Account findByOwnerCPF(String ownerCPF) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> query = accountCollection
                .whereEqualTo("ownerCPF", ownerCPF)
                .get();

        List<QueryDocumentSnapshot> documents = query.get().getDocuments();

        if (!documents.isEmpty()) {
            return documents.get(0).toObject(Account.class);
        }
        return null;
    }

    @Override
    public void deleteById(String id) throws ExecutionException, InterruptedException {
        accountCollection.document(id).delete().get();
    }
}