#!/bin/bash

#This script takes a json file of documents with index "records" and type "human"
#and indexes them into the
#local elasticsearch server using the bulk API and jq 
#https://stedolan.github.io/jq/
#

if [[ $# -ne 1 ]] 
	then
		echo "Please supply json file, exiting..."
		exit
fi

cat $1 | jq -c '.[] | {"index": {"_index": "records", "_type": "human", "_id": .id}}, .' | curl -XPOST localhost:9200/_bulk --data-binary @-
