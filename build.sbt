name := "cassandra-kafka-streaming"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.0.0" % "provided"

libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.0.0" % "provided"

libraryDependencies += ("com.datastax.spark" %% "spark-cassandra-connector" % "2.0.0").exclude("io.netty", "netty-handler")

libraryDependencies += ("com.datastax.cassandra" % "cassandra-driver-core" % "3.0.0").exclude("io.netty", "netty-handler")

libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.0.0" % "provided"

libraryDependencies += ("org.apache.spark" %% "spark-streaming-kafka-0-8" % "2.0.0").exclude("org.spark-project.spark", "unused")

// There is a conflict between Guava versions on Cassandra Drive and Hadoop
 // Shading Guava Package
assemblyShadeRules in assembly := Seq(ShadeRule.rename("com.google.**" -> "shadeio.@1").inAll)
 
assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}

