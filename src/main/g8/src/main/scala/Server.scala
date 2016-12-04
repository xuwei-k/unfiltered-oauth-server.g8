package com.example

import unfiltered.oauth._
import unfiltered.jetty.SocketPortBinding
import java.net.URL
/** oauth server */
object Server {
  val port = 8080

  def main(args: Array[String]) {
    val host = new Host
    val stores = Stores(host)
    val binding = SocketPortBinding(host = "localhost", port = port)
    unfiltered.jetty.Server.portBinding(binding)
      .resources(new URL(getClass.getResource("/web/robots.txt"), "."))
      .context("/oauth") { _.filter(OAuth(stores)) }
      .filter(new App(host, stores.tokens, stores.consumers))
      .context("/api") {
        _.filter(Protection(stores))
         .filter(Api)
      }.run { s =>
        unfiltered.util.Browser.open(binding.host + ":" + binding.port)
      }
  }
}
