package com.example

import unfiltered.request._
import unfiltered.filter.request.ContextPath
import unfiltered.response._

object Api extends unfiltered.filter.Plan {

  import unfiltered.oauth.OAuth.XAuthorizedIdentity

  import org.json4s.JsonDSL._
  import org.json4s.native.JsonMethods._

  def intent = {
    case GET(ContextPath(_,"/user") & request) =>
      request.underlying.getAttribute(XAuthorizedIdentity) match {
        case identity: String =>
          val json = ("id" -> identity) ~
            ("likes" -> List("sweets"))
          JsonContent ~> ResponseString(compact(render(json)))
        case _ =>
          JsonContent ~> ResponseString("""{"id":"unknown"}""")
      }

    case GET(path) =>
      JsonContent ~> ResponseString("""{"unhandled_path}":"%s"}""" format(path))
  }
}
