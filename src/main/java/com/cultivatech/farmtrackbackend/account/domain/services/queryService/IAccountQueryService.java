package com.cultivatech.farmtrackbackend.account.domain.services.queryService;

import com.cultivatech.farmtrackbackend.account.domain.model.queries.GetEmailAndTypeByAccountIdQuery;
import com.cultivatech.farmtrackbackend.account.domain.model.queries.GetSpecialistsQuery;
import com.cultivatech.farmtrackbackend.account.domain.model.aggregates.Account;
import com.cultivatech.farmtrackbackend.account.domain.model.queries.GetAccountByEmailQuery;

import java.util.List;

public interface IAccountQueryService {
    Account handle(GetEmailAndTypeByAccountIdQuery getEmailAndTypeByAccountIdQuery);
    Account handle(GetAccountByEmailQuery getAccountByEmailQuery);
    List<Account> handle(GetSpecialistsQuery getSpecialistsQuery);
}
