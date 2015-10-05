spark + elasticsearch + git fun.

This project indexes 10k documents into a local elasticsearch server and extracts them to print to ide console. 

script: scripts/index_es_bulk.sh

You will need jq to run the script. It's used to get the json file in the proper bulk api format for indexing into the elastic server. 

https://stedolan.github.io/jq/


To install:

linus: 

apt : sudo apt-get install jq

yum: sudo yum install jq

osx:

homebrew: brew install jq

https://stedolan.github.io/jq/download/


An online JSON generator was used to create dummy data: http://jsongen.pykaso.net/

data: data/generated.json

comman line: ./index_es_bulk.sh generated.json


SimpleSparkJob.java: A spark job reads in all documents with index "records" and type "human" from es server and prints them to the screen. 
