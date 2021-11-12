package routers

import controllers.ProductController

import javax.inject.{Inject, Singleton}
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._


@Singleton
class ProductRouter @Inject()(val controller: ProductController) extends SimpleRouter {
  val prefix = "/products"

  override def routes: Routes = {
    case GET(p"/") =>
      controller.getProducts

//    case POST(p"/") =>
//      controller.process
//
//    case GET(p"/$id") =>
//      controller.show(id)
  }
}
