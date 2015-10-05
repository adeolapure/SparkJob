package com.evertrue.spark;

/**
 *
 * This function reads in all documents with index "records" and type "human"
 * from the local elasticsearch server with a spark job
 * and prints them to the screen
 *
 **/

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.List;
import java.util.Map;

import static org.elasticsearch.spark.rdd.api.java.JavaEsSpark.esRDD;


public class SimpleSparkJob {

    public static void main(String[] args) {

        //set up with default values (localhost, 9200 etc)
        SparkConf conf = new SparkConf().setAppName("SimpleSparkTest").setMaster("local");
        JavaSparkContext jsc = new JavaSparkContext(conf);

        //get all Documents with index "records", and type "human", bypass the id key pairing, don't need for printing
        JavaRDD<Map<String, Object>> esRDD = esRDD(jsc, "records/human").values();

        //gather up values and print
        List<Map<String,Object>> docs = esRDD.collect();
        String format = "%-30s%-10s%-35s%-30s%n";
        for (Map m : docs) {
            System.out.printf(format, "Name: " + m.get("name"), "Age: " + m.get("age"), "Email: " + m.get("email"), "Active: " + m.get("active"));
        }

    }
}