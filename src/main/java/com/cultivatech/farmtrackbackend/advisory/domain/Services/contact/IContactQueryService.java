package com.cultivatech.farmtrackbackend.advisory.domain.Services.contact;

import com.cultivatech.farmtrackbackend.advisory.domain.model.entities.Contact;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.contact.GetContactByIdQuery;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.contact.GetContactsByFarmerIdQuery;
import com.cultivatech.farmtrackbackend.advisory.domain.model.queries.contact.GetContactsBySpecialistIdQuery;

import java.util.List;

public interface IContactQueryService {
    List<Contact> handle(GetContactsByFarmerIdQuery getContactsByFarmerIdQuery);
    List<Contact> handle(GetContactsBySpecialistIdQuery getContactsBySpecialistIdQuery);
    Contact handle(GetContactByIdQuery getContactByIdQuery);
}
