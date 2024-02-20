package com.my.bookstore_backend.serviceimpl;

import com.my.bookstore_backend.service.CountService;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

@Service
public class CountServiceImpl implements CountService {
    private JavaSparkContext sparkContext;

    @Override
    public void countKeywords(String path, List<String> keywords) {
        SparkConf conf = new SparkConf().setAppName("Count keywords").setMaster("local");
        this.sparkContext = new JavaSparkContext(conf); //error
        JavaRDD<String> lines = sparkContext.textFile(path);

        JavaPairRDD<String, Integer> counts = lines
                .flatMap(line -> Arrays.asList(line.split(" ")).iterator())
                .filter(word -> keywords.contains(word))
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey(Integer::sum);

        counts.collect().forEach(tuple -> System.out.println(tuple._1 + ": " + tuple._2));
    }
}
