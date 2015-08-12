# Joker
Example of inter-dependented complex Gradle Projects.
Components:
*  A Java Library supplying jokes
*  An Android Library displays jokes passed to its Activity Via an intent.
*  A Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
*  Connected tests to verify that the async task is indeed loading jokes.
*  Paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.
