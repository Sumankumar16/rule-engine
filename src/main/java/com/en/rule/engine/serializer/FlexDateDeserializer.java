package com.en.rule.engine.serializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;

/**
 * @see <a href="http://www.baeldung.com/jackson-serialize-dates">Jackon Custom
 *      date serialization</a>
 * @see <a href=
 *      "http://www.leveluplunch.com/java/tutorials/033-custom-jackson-date-deserializer/">Jackon
 *      Custom date serialization</a>
 */
public final class FlexDateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

		final String date = parser.getText();
		try {
			return formatter.parse(date);
		} catch (final ParseException ex) {
			return DateDeserializer.instance.deserialize(parser, context);
		}
	}
}