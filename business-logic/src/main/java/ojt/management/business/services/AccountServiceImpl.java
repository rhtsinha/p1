package ojt.management.business.services;


import ojt.management.data.entities.Account;
import ojt.management.data.repositories.AccountRepository;
import ojt.management.payload.request.LoginRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllUsers() {
        return accountRepository.findAll();
    }

    @Override
    public Account getUserById(Long id) {
        return accountRepository.getById(id);
    }

    @Override
    public List<Account> searchUser(String name, String email, String phone) { return accountRepository.searchUser(name, email, phone); }

    @Override
    public Account updateUser(String phone, String address, String password, Timestamp updateAt) {
            LoginRequest loginRequest = new LoginRequest();
            String email = loginRequest.getEmail();
            Account account = accountRepository.findByEmail(email);
            account.setPhone(phone);
            account.getStudent().setAddress(address);
            account.setPassword(password);
            account.setUpdatedAt(updateAt);
            accountRepository.save(account);
            return accountRepository.getById(account.getId());
    }

}
