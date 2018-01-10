package net.ndolgov.restgatewaytest

import java.io.StringWriter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

import scala.reflect.ClassTag

/** Scala wrapper for a popular Java JSON serialization library*/
object JsonMarshaller {
  private val marshaller = new ObjectMapper().registerModule(new DefaultScalaModule())

  def toJson[T](value: T): String = {
    val writer = new StringWriter
    marshaller.writeValue(writer, value)
    writer.toString
  }

  def fromJson[T: ClassTag](json: String, clazz: Class[T]) : T = {
    marshaller.readValue(json, clazz)
  }
}
