package com.yavuzozguven.Mllib

import org.apache.spark.{SparkConf, SparkContext}

object Classification extends App {
  val conf = new SparkConf().setMaster("local").setAppName("Project")
  val sc = new SparkContext(conf)


  val rdd = sc.textFile("tennis.csv")
  val res = new com.yavuzozguven.MaRe(rdd)
    .map(
      inputMountPoint = com.yavuzozguven.TextFile("/input"),
      outputMountPoint = com.yavuzozguven.TextFile("/output"),
      imageName = "mllib",
      command = "java -cp project.jar com.yavuzozguven.Classification > output")
    .rdd.collect()

  res.foreach(println(_))
}
