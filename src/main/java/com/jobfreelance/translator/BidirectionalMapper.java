package com.jobfreelance.translator;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.metadata.Type;

import java.time.Instant;
import java.util.Date;


public abstract class BidirectionalMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
       factory.getConverterFactory().registerConverter(new DateInstantConverter());
    }

    protected static class DateInstantConverter extends BidirectionalConverter<Date, Instant>{
        @Override
        public Instant convertTo(Date date, Type<Instant> type, MappingContext mappingContext) {
            return date.toInstant();
        }

        @Override
        public Date convertFrom(Instant instant, Type<Date> type, MappingContext mappingContext) {
            return Date.from(instant);
        }
    }
}
