package com.example.countkeywords;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

@Service
public class CountService{
    private final JavaSparkContext sparkContext;

    @Autowired
    public CountService(){
        SparkConf conf = new SparkConf().setAppName("count keywords").setMaster("local");
        this.sparkContext = new JavaSparkContext(conf);
    }


    public void countKeywords(String path, List<String> keywords) {

        JavaRDD<String> lines = sparkContext.textFile(path);

        JavaPairRDD<String, Integer> counts = lines
                .flatMap(line -> Arrays.asList(line.split(" ")).iterator())
                .filter(word -> keywords.contains(word))
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey(Integer::sum);

        counts.collect().forEach(tuple -> System.out.println(tuple._1 + ": " + tuple._2));
    }
}
