# apache_livy_demo
Simple demo of Apache Livy. Using Java code, I will run batch pyspark jobs using the Livy API.

# What is Livy?
* A service that enables easy interaction with a Spark cluster over a REST interface<sup>[1]</sup>
* Enables easy submission of Spark jobs via simple REST interface<sup>[1]</sup>
* Enables use of Spark for interactive web applications<sup>[1]</sup>

# Advantages of Livy
* Multiple users can interact with the Spark cluster concurrently and reliably<sup>[1]</sup>
* Multiple Spark Contexts can be managed simultaneously<sup>[1]</sup>
* Client does not need Spark installed<sup>[2]</sup>
* Interacting with Livy is language agnostic because any language can interact with Livy REST API

# Livy Server Architecture<sup>[2]</sup>
![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/livy_server_architecture.png)

# Demo: Run Spark job using spark-submit

```spark-submit --py-files spark_example_utils.zip spark_example.py test_arg_1```
<br/><br/>
![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/spark_submit_cmd.png)

[`spark_example.py`](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/pyfiles/spark_example.py) is a simple pyspark script that estimates the value of pi, create a text file, and save into the [`outputs`](https://github.com/danielhanbitlee/apache_livy_demo/tree/master/outputs) directory.
# Demo: Run Spark job using Apache Livy

1. Follow instructions on installing the Livy server from [here](https://github.com/apache/incubator-livy).
2. Start the Livy server from appropriate directory. See image below:
    ```./livy-server start```
    <br/><br/>
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/livy_server_start.png)
3. Go to <http://localhost:8998/ui> to see the user interface that comes with the Livy server.
<br/><br/>
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/initial_livy_ui.png)
4. Go to appropriate directory and submit a batch spark job using Java code. [`PostToLivy.java`](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/src/PostToLivy.java) code is below: 
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/PostToLivy.png)
    Note how ```spark-submit --py-files spark_example_utils.zip spark_example.py test_arg_1``` has been transformed in this Java code that interacts with the Livy REST API.  
    &nbsp;&nbsp;&nbsp;&nbsp;a. Compile Java code: ```javac PostToLivy.java```
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/javac_PostToLivy.png)
    &nbsp;&nbsp;&nbsp;&nbsp;b. Run Java code: ```java PostToLivy```
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/java_PostToLivy.png)
    &nbsp;&nbsp;&nbsp;&nbsp;c. See how Livy user interface has been updated.
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/PostToLivy_ui.png)
    &nbsp;&nbsp;&nbsp;&nbsp;d. See the logs from Livy Server user interface.
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/PostToLivy_ui_log.png)
5. Get status of batch spark job using Java code. [`GetLivy.java`](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/src/GetLivy.java) code is below:
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/GetLivy.png)
    &nbsp;&nbsp;&nbsp;&nbsp;a. Compile Java code: ```javac GetLivy.java```
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/javac_GetLivy.png)
    &nbsp;&nbsp;&nbsp;&nbsp;b. Run Java code: ```java GetLivy batches 0```  
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/java_GetLivy.png)
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Notice that I passed in arguments `batches` and `0` to `GetLivy.java`.  
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* `batches` refer to the type of Spark job submitted to Livy  
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* `0` is the batch id number.
6. Submit multiple batch jobs to Livy.
7. Delete a batch job using Java code. [`DeleteLivy.java`](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/src/DeleteLivy.java) code is below:
![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/DeleteLivy.png)
    &nbsp;&nbsp;&nbsp;&nbsp;a. Compile Java code: ```javac DeleteLivy.java```
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/javac_DeleteLivy.png)
    &nbsp;&nbsp;&nbsp;&nbsp;b. Run Java code: ```java DeleteLivy batches 0```  
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/java_DeleteLivy.png)
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Notice that I passed in arguments `batches` and `0` to `GetLivy.java`.  
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* `batches` refer to the type of Spark job submitted to Livy  
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* `0` is the batch id number.
8. Go to appropriate directory and shut down Livy server:
 ```./livy-server stop```
 <br/><br/>
    ![](https://github.com/danielhanbitlee/apache_livy_demo/blob/master/images/livy_server_stop.png)

# References
1. <https://livy.apache.org>
2. <https://www.linkedin.com/pulse/submitting-spark-jobs-remote-cluster-via-livy-rest-api-ramasamy/>
