package com.example.party2.model.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EventStatusConverter implements AttributeConverter<EventStatus,Integer> {


    @Override
    public Integer convertToDatabaseColumn(EventStatus attribute) {
        return attribute == null ? EventStatus.PENDING.getId() : attribute.getId();
    }

    @Override
    public EventStatus convertToEntityAttribute(Integer dbData) {
        return dbData == null ? EventStatus.PENDING : EventStatus.getById(dbData);
    }
}
