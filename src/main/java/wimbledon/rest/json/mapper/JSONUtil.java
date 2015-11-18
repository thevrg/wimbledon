package wimbledon.rest.json.mapper;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonValue;

/**
 *
 * @author vrg
 */
public class JSONUtil {

    public static Collector<JsonValue, JsonArrayBuilder, JsonArray> toJsonArray() {
        return new JsonArrayCollector<>(
                (JsonArrayBuilder builder, JsonValue value) -> builder.add(value));
    }

    public static Collector<String, JsonArrayBuilder, JsonArray> toJsonArrayOfStrings() {
        return new JsonArrayCollector<>(
                (JsonArrayBuilder builder, String value) -> builder.add(value));
    }

    public static Collector<Long, JsonArrayBuilder, JsonArray> toJsonArrayOfLongs() {
        return new JsonArrayCollector<>(
                (JsonArrayBuilder builder, Long value) -> builder.add(value));
    }

    public static <T> Collector<T, JsonArrayBuilder, JsonArray> toJsonArray(BiConsumer<JsonArrayBuilder, T> accumulator) {
        return new JsonArrayCollector<>(accumulator);
    }

    static class JsonArrayCollector<T> implements Collector<T, JsonArrayBuilder, JsonArray> {

        private final BiConsumer<JsonArrayBuilder, T> accumulator;

        public JsonArrayCollector(BiConsumer<JsonArrayBuilder, T> accumulator) {
            this.accumulator = accumulator;
        }

        @Override
        public Supplier<JsonArrayBuilder> supplier() {
            return () -> Json.createArrayBuilder();
        }

        @Override
        public BiConsumer<JsonArrayBuilder, T> accumulator() {
            return accumulator;
        }

        @Override
        public BinaryOperator<JsonArrayBuilder> combiner() {
            return (JsonArrayBuilder builder1, JsonArrayBuilder builder2)
                    -> builder1.add(builder2);
        }

        @Override
        public Function<JsonArrayBuilder, JsonArray> finisher() {
            return (JsonArrayBuilder builder) -> builder.build();
        }

        @Override
        public Set<Collector.Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.noneOf(Collector.Characteristics.class));
        }
    }
}
