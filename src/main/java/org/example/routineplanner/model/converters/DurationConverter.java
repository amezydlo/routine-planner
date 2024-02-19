package org.example.routineplanner.model.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

@Converter(autoApply = true)
public class DurationConverter implements AttributeConverter<Duration, Long> {

    Logger log = Logger.getLogger(DurationConverter.class.getSimpleName());


    @Override
    public Long convertToDatabaseColumn(Duration duration) {
        log.info("Convert Duration to Long");
        return duration.toNanos();
    }

    @Override
    public Duration convertToEntityAttribute(Long duration) {
        log.info("Convert Long (ns) to Duration");
        return Duration.of(duration, ChronoUnit.NANOS);
    }
}
