package com.movie.script.analysis;

import java.io.IOException;
import java.util.HashSet;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class UniqueWordsReducer extends Reducer<Text, Text, Text, Text> {

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        HashSet<String> uniqueWords = new HashSet<>();
        for (Text val : values) {
            uniqueWords.add(val.toString());
        }
        context.write(key, new Text(String.join(", ", uniqueWords)));

    }
}
