# apache_livy_demo
Simple demo of Apache Livy. Using Java code, I will run pyspark using Livy API.

# What is Livy?
* A service that enables easy interaction with a Spark cluster over a REST interface<sup>[1]</sup>
* Enables easy submission of Spark jobs via simple REST interface<sup>[1]</sup>
* Enables use of Spark for interactive web applications<sup>[1]</sup>

# Advantages of Livy
* Multiple users can interact with the Spark cluster concurrently and reliably<sup>[1]</sup>
* Multiple Spark Contexts can be managed simultaneously<sup>[1]</sup>
* Spark Contexts run on the cluster instead of the Livy Server<sup>[1]</sup>

***include picture from website***

# Demo: Run Spark job Using spark-submit

```spark-submit --py-files spark_example_utils.zip spark_example.py test_arg_1```

# Demo: Run Spark job Using Apache Livy

1. Start the Livy server:
    ```./livy-server start```
* adfaf

# References
1. <https://livy.apache.org>
