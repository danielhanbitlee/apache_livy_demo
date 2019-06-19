import os
import sys
import datetime
import glob
from pyspark import SparkContext
import importlib

arg1 = sys.argv[1]

if arg1 == "test_arg_1":
    sys.path.insert(0, 'spark_example_utils.zip')
    
    spark_example_utils = importlib.import_module('spark_example_utils.spark_example_utils')
    
    sc = SparkContext()
    NUM_SAMPLES = 100000
    
    count = sc.parallelize(range(0, NUM_SAMPLES)).map(spark_example_utils.sample).reduce(lambda a, b: a + b)
    pi = 4.0 * count / NUM_SAMPLES
    livy_example_dir = "/home/daniel/Documents/GitHub/apache_livy_demo"
    files_to_delete = glob.glob(f"{livy_example_dir}/outputs/*.txt")
    print(f"files_to_delete: {files_to_delete}")
    for f in files_to_delete:
        os.remove(f)
    output_file = f"output_{datetime.datetime.now()}.txt"
    print(f"directory to write file: {livy_example_dir}/outputs/{output_file}")
    with open(f"{livy_example_dir}/outputs/{output_file}", "w") as write_file:
        write_file.write("pi: " + str(pi))
    print(f"Pi is roughly {pi}")
else:
    print("fail")
