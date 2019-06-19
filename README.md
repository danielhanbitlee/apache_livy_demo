# apache_livy_demo
Simple demo of Apache Livy. Using Java code, I will run pyspark jobs using the Livy API.

# What is Livy?
* A service that enables easy interaction with a Spark cluster over a REST interface<sup>[1]</sup>
* Enables easy submission of Spark jobs via simple REST interface<sup>[1]</sup>
* Enables use of Spark for interactive web applications<sup>[1]</sup>

# Advantages of Livy
* Multiple users can interact with the Spark cluster concurrently and reliably<sup>[1]</sup>
* Multiple Spark Contexts can be managed simultaneously<sup>[1]</sup>
* Spark Contexts run on the cluster instead of the Livy Server<sup>[1]</sup>
* Client does not need Spark installed<sup>[2]</sup>

# Livy Server Architecture<sup>[2]</sup>
![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/livy_server_architecture.png)

# Demo: Run Spark job Using spark-submit

```spark-submit --py-files spark_example_utils.zip spark_example.py test_arg_1```
![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/spark_submit_cmd.png)

`spark_example.py` is a simple pyspark script that estimates the value of pi, create a text file, and save into the `outputs` directory.
# Demo: Run Spark job Using Apache Livy

1. Follow instructions on installing the Livy server from [here](https://github.com/apache/incubator-livy).
2. Start the Livy server:
    ```./livy-server start```
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/livy_server_start.png)
3. Go to <http://localhost:8998/ui> to see the user interface that comes with the Livy server.
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/initial_livy_ui.png)
4. Submit a spark job using Java code. [`PostToLivy.java`](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/src/PostToLivy.java) code is below:  
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/PostToLivy.png)
    Note how ```spark-submit --py-files spark_example_utils.zip spark_example.py test_arg_1``` has been transformed in this Java code that interacts with the Livy REST API.  
      a. Compile Java code: ```javac PostToLivy.java```  
      b. Run Java code: ```java PostToLivy```  
      c. See how Livy user interface has been updated.
# References
1. <https://livy.apache.org>
2. <https://www.linkedin.com/pulse/submitting-spark-jobs-remote-cluster-via-livy-rest-api-ramasamy/>
