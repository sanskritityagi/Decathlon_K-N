package com.kuehnenagel.decathlon.Services;

import com.kuehnenagel.decathlon.Exception.ReadFileException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {

    public List<String> read(String filePath) {
        try (Stream<String> stream = stream(Optional.ofNullable(filePath).orElse(""))) {
            return stream
                    .filter(this::nonBlank)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ReadFileException(e.getMessage());
        }
    }

    private Stream<String> stream(String filePath) throws IOException, URISyntaxException {
        if (exists(filePath)) {
            return Files.lines(Paths.get(filePath));
        }

        return Files.lines(Paths.get(getClass().getResource("/results.csv").toURI()));
    }

    private boolean exists(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path) && !Files.isDirectory(path);
    }

    private boolean nonBlank(String line) {
        return line != null && ! line.isEmpty();
    }

}


