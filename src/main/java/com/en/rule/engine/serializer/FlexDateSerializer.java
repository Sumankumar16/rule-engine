package com.en.rule.engine.serializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @see <a href="http://www.baeldung.com/jackson-serialize-dates">Jackon Custom
 *      date serialization</a>
 * @see <a href=
 *      "http://www.leveluplunch.com/java/tutorials/033-custom-jackson-date-deserializer/">Jackon
 *      Custom date serialization</a>
 */
public final class FlexDateSerializer extends JsonSerializer<Date> {
	private static final Logger LOG = LoggerFactory.getLogger(FlexDateSerializer.class);

	@Override
	public void serialize(final Date value, final JsonGenerator gen, final SerializerProvider arg2) throws IOException {
		String formattedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX").format(value);
		LOG.info("Serializing date: {}", formattedDate);
		gen.writeString(formattedDate);
		LOG.info("Date serialized");
	}
}
