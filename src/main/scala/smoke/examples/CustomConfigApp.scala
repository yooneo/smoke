package smoke.examples

import smoke._

import akka.actor._
import com.mdialog.config.Config

object CustomConfigApp extends Smoke {

  Config.reconfigure("configuration.properties")

  onRequest {
    case GET(Path("/example")) ⇒ reply {
      Thread.sleep(1000)
      Response(Ok, body = "It took me a second to build this response.\n")
    }
    case _ ⇒ reply(Response(NotFound))
  }

  after { response ⇒
    val headers = response.headers ++ Map(
      "Server" -> "BasicExampleApp/0.0.1",
      "Connection" -> "Close")
    Response(response.status, headers, response.body)
  }
}
