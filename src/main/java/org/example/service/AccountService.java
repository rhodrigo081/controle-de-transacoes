package org.example.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.example.model.Account;
import org.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class AccountService implements AccountRepository {

    private final Firestore fireStore;
    private final CollectionReference accountCollection;

    @Autowired
    public AccountService(Firestore fireStore) {
        this.fireStore = fireStore;
        this.accountCollection = fireStore.collection("accounts");
    }

    @Override
    public Account createAccount(String ownerName, String ownerCPF, String password, String type) throws ExecutionException, InterruptedException {
        DocumentReference docRef = accountCollection.document();

        if (ownerCPF == null || ownerCPF.isEmpty() ||
                ownerName == null || ownerName.isEmpty() ||
                password == null || password.isEmpty() ||
                type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Todos os campos são obrigatórios!");
        }

        ApiFuture<QuerySnapshot> query = accountCollection
                .whereEqualTo("ownerCPF", ownerCPF)
                .get();

        if (!query.get().isEmpty()) {
            throw new IllegalArgumentException("CPF já cadastrado!");
        }

        Account account = new Account();
        account.setId(docRef.getId());
        account.setOwnerName(ownerName);
        account.setOwnerCPF(ownerCPF);
        account.setPassword(password);
        account.setType(type);

        ApiFuture<WriteResult> result = docRef.set(account);
        result.get();

        return account;
    }


    @Override
    public Account loginAccount(String ownerCPF, String password) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> query = accountCollection
                .whereEqualTo("ownerCPF", ownerCPF)
                .whereEqualTo("password", password)
                .get();

        List<QueryDocumentSnapshot> documents = query.get().getDocuments();

        if (!documents.isEmpty()) {
            return documents.get(0).toObject(Account.class);
        }
        return null;
    }

    @Override
    public Account findByOwnerName(String ownerName) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> query = accountCollection
                .whereEqualTo("ownerName", ownerName)
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