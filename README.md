spark + elasticsearch + git fun.

This project indexes 10k documents into a local elasticsearch server. 

script: scripts/index_es_bulk.sh
data: data/generated.json

SparkJob.java: A spark job reads in all 10k documents from es server and prints them to the screen. 
SparkJob
